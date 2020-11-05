package com.lsj.springboot.Util.MuiltThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by 10326 on 2020/2/6.
 * 线程池、semaphore、countDownLatch、原子类AtomicBoolean
 */
public class MySemaphore {
    private static AtomicBoolean isHappened = new AtomicBoolean(false);
    public static int clientTotal = 5000;
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println("exception" + e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("isHappened:{}" + isHappened.get());
        try {
             //显示加载类
            isHappened.getClass().getClassLoader().loadClass("");
            //isHappened.getClass().forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * isHappened.compareAndSet(false, true)；
       unsafe.compareAndSwapInt(this, valueOffset, e, u);
       compareAndSet这个方法主要调用unsafe.compareAndSwapInt这个方法，
       这个方法有四个参数，其中第一个参数为需要改变的对象，第二个为偏移量(即之前求出来的valueOffset的值)（内存原值）
      ，第三个参数为期待的值，第四个为更新后的值。整个方法的作用即为若调用该方法时，value的值与expect这个值相等，
     那么则将value修改为update这个值，并返回一个true，如果调用该方法时，value的值与expect这个值不相等，那么不做任何操作，并范围一个false。
     */
    public static void test() {
        if (isHappened.compareAndSet(false, true)) {
            System.out.println("execute");
        }
    }
}
