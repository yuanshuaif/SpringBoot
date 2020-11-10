package com.lsj.springboot.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperLock2Test {
    public static void main(String[] args){
        try {
            testLock();
        }catch (Exception e){

        }
    }
    public static void testLock() throws IOException, InterruptedException, KeeperException {
        final String zookeeperHost = "10.6.245.163";
        final String zookeeperPort = "2181";
        final String lockName = "testLock2";
        final int threadCnt = 9;
        final CountDownLatch countDownLatchConnect = new CountDownLatch(1);
        final ZooKeeper zooKeeper = new ZooKeeper(zookeeperHost + ":" + zookeeperPort, 60000, event -> {
            if (event.getState().equals(Watcher.Event.KeeperState.SyncConnected)) {
                countDownLatchConnect.countDown();
            }
        });
        countDownLatchConnect.await();

        final CountDownLatch countDownLatchThread = new CountDownLatch(threadCnt);
        for (int i = 1; i <= threadCnt; i++) {
            Runnable runnable = () -> {
                try {
                    ZookeeperLock2 zookeeperLock2 = new ZookeeperLock2(zooKeeper, lockName);
                    zookeeperLock2.getLock();
                    System.out.println(Thread.currentThread().getName() + "：获得锁");
                    Thread.sleep(2000);
                    zookeeperLock2.freeLock();
                    System.out.println(Thread.currentThread().getName() + "：释放锁");
                } catch (InterruptedException | KeeperException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatchThread.countDown();
                }
            };
            Thread thread = new Thread(runnable, "线程" + i);
            thread.start();
        }
        countDownLatchThread.await();
    }
}
