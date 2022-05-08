package com.lsj.springboot.zk;

import org.apache.zookeeper.*;

/**
 * 一、使用zookeeper原生api实现分布式锁
 * 1、思路一：利用Zookeeper不能重复创建一个节点的特性来实现一个分布式锁
 * 流程：
 * 1.需要获得锁时创建锁node节点。
 * 2.如果创建失败，则表示该锁已经被别人占用，watch该节点状态，等待锁。
 * 3.如果创建成功，则表示获得锁。
 * 4.主动释放锁时删除对应的node节点即可。
 * 5.获得锁的session超时或断开，由于锁node为临时节点则该节点也会删除。
 * 6.节点删除时watch该节点的线程重新争抢锁。
 * 优点：
 * 1.实现比较简单，可拿来即用
 * 2.有通知机制，能提供较快的响应
 * 3.通过临时节点机制，保证节点能及时删掉
 * 缺点：
 * 1.有惊群效应。一个节点删除的时候，大量对这个节点的删除动作有订阅Watcher的线程会进行回调。
 */
public class ZookeeperLock1 implements Lock {
    private final String zookeeperLockRootNode = "zookeeperLock";

    private final ZooKeeper zooKeeper;
    private final String lockName;

    private class LockWatcher implements Watcher {

        // 该watch对应的需要获得锁的线程
        private final Thread thread;

        private LockWatcher(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void process(WatchedEvent event) {
            if (event.getType().equals(Watcher.Event.EventType.NodeDeleted)) {
                synchronized (thread) {
                    thread.notifyAll();
                }
            }
        }
    }

    public ZookeeperLock1(ZooKeeper zooKeeper, String lockName) throws KeeperException, InterruptedException {
        this.lockName = lockName;
        this.zooKeeper = zooKeeper;
        // 检查所有锁的根节点，如果没有则创建。
        try {
            zooKeeper.create("/" + zookeeperLockRootNode, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            if (!e.code().equals(KeeperException.Code.NODEEXISTS)) {
                throw e;
            }
        }
    }

    @Override
    public void getLock() throws KeeperException, InterruptedException {
        String zookeeperLockNodeName = "/" + zookeeperLockRootNode + "/" + lockName;
        while (true) {
            // 直接创建锁节点，创建成功则表示拿到锁则return。返回节点存在异常则表示获取锁失败则等待锁。
            try {
                zooKeeper.create(zookeeperLockNodeName, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                break;
            } catch (KeeperException e) {
                if (!e.code().equals(KeeperException.Code.NODEEXISTS)) {
                    throw e;
                }
            }
            // 添加节点监控
            if(zooKeeper.exists(zookeeperLockNodeName, new LockWatcher(Thread.currentThread())) != null) {//监听器添加成功，才能线程挂起等待被唤醒
                synchronized (Thread.currentThread()) {
                    // 线程等待锁，只有在删除节点的watch中才会重新激活线程
                    Thread.currentThread().wait();
                }
            }
        }
    }

    @Override
    public void freeLock() throws KeeperException, InterruptedException {
        String zookeeperLockNodeName = "/" + zookeeperLockRootNode + "/" + lockName;
        zooKeeper.delete(zookeeperLockNodeName, -1);
    }
}
