package com.lsj.springboot.zk;

import org.apache.zookeeper.*;

import java.util.Collections;
import java.util.List;

/**
 * 2、思路二：利用Zookeeper顺序节点特性来实现一个分布式锁
 * 由于思路一实现的分布式锁有惊群效应，所以我们可以利用zookeeper顺序节点特性避免比效果。流程如下：
 * 1.需要获得锁时创建顺序临时节点。
 * 2.查看该节点是否为最小节点，如果是则表示获得锁，如果否则表示锁已经被别人占用，watch该节点上一个顺序节点，等待锁。
 * 3.主动释放锁时删除最小节点即可。
 * 4.获得锁的session超时或断开，由于锁node为临时节点则该节点也会删除。
 * 5.节点删除时watch该节点的下一个节点会重新判断自己是否为最小节点，执行第2步。
 */
public class ZookeeperLock2 implements Lock{
    private final String zookeeperLockRootNode = "zookeeperLock";
    private final String zookeeperLockPrefix = "lock_";

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

    public ZookeeperLock2(ZooKeeper zooKeeper, String lockName) throws InterruptedException, KeeperException {
        this.zooKeeper = zooKeeper;
        this.lockName = lockName;
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
    public void getLock() throws InterruptedException, KeeperException {
        String zookeeperLockNodeName = "/" + zookeeperLockRootNode + "/" + lockName;
        try {
            zooKeeper.create(zookeeperLockNodeName, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            if (!e.code().equals(KeeperException.Code.NODEEXISTS)) {
                throw e;
            }
        }
        // 创建临时顺序节点
        String zookeeperLockSubNodeName = zooKeeper.create(zookeeperLockNodeName + "/" + zookeeperLockPrefix, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        while (true) {
            // 获取该锁下所有子节点并排序
            List<String> zookeeperLockNodeChildren = zooKeeper.getChildren(zookeeperLockNodeName, false);
            Collections.sort(zookeeperLockNodeChildren);
            // 判断刚刚创建的节点是否为所有子节点中最小的那个，如果是则表示获得锁，如果否则表示等待锁
            if (zookeeperLockSubNodeName.equals(zookeeperLockNodeName + "/" + zookeeperLockNodeChildren.get(0))) {
                break;
            } else {
                // 获取刚刚创建节点的上一个顺序节点
                String zookeeperLockPriorNodeName = zookeeperLockNodeName + "/" + zookeeperLockNodeChildren.get(0);
                for (int i = 0; i < zookeeperLockNodeChildren.size(); i++) {
                    if (zookeeperLockSubNodeName.equals(zookeeperLockNodeName + "/" + zookeeperLockNodeChildren.get(i))) {
                        break;
                    } else {
                        zookeeperLockPriorNodeName = zookeeperLockNodeName + "/" + zookeeperLockNodeChildren.get(i);
                    }
                }
                // 监视刚刚创建节点的上一个顺序节点
                zooKeeper.exists(zookeeperLockPriorNodeName, new LockWatcher(Thread.currentThread()));
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
        // 获取该锁下所有子节点并排序
        List<String> zookeeperLockNodeChildren = zooKeeper.getChildren(zookeeperLockNodeName, false);
        Collections.sort(zookeeperLockNodeChildren);
        // 删除节点
        zooKeeper.delete(zookeeperLockNodeName + "/" + zookeeperLockNodeChildren.get(0), -1);
    }
}
