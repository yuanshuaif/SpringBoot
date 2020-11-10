package com.lsj.springboot.zk;

import java.util.concurrent.CountDownLatch;

/**
 * Curator是Netflix公司开源的一个Zookeeper客户端，
 * 与Zookeeper提供的原生客户端相比，Curator的抽象层次更高，简化了Zookeeper客户端的开发量。用Curator实现zookeeper的分布式锁非常简单。
 */
public class ZookeeperLock3Test {
    public void testLock() throws InterruptedException {
        final String zookeeperHost = "10.5.31.155";
        final String zookeeperPort = "2181";
        final int threadCnt = 9;

       /* final CuratorFramework zkClient = CuratorFrameworkFactory.newClient(zookeeperHost + ":" + zookeeperPort, new RetryNTimes(3, 5000));
        zkClient.start();

        CountDownLatch countDownLatch = new CountDownLatch(threadCnt);
        for (int i = 1; i <= threadCnt; i++) {
            Runnable runnable = () -> {
                InterProcessMutex zkLock = new InterProcessMutex(zkClient, "/zookeeperLock/testLock3");
                try {
                    zkLock.acquire();
                    System.out.println(Thread.currentThread().getName() + "：获得锁");
                    Thread.sleep(2000);
                    zkLock.release();
                    System.out.println(Thread.currentThread().getName() + "：释放锁");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            };
            Thread thread = new Thread(runnable, "线程" + i);
            thread.start();
        }
        countDownLatch.await();

        zkClient.close();*/
    }
}
