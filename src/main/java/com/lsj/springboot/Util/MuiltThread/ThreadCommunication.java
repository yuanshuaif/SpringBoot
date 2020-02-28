package com.lsj.springboot.Util.MuiltThread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by 10326 on 2020/1/30.
 * 线程间通信
 */
public class ThreadCommunication {

    /**
     * 1.线程间通信顺序打印123   join
     */
    private static void demo2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
    }

    /**
     * 2.线程间通信交叉打印  wait、notify
     */
    private static void demo3() {
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();// 必须先获取该对象的对象锁，否则抛出异常java.lang.IllegalMonitorStateException
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        A.start();
        try {
            Thread.sleep(200);// 保证A先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B.start();
    }

    /**
     * 3.一个线程同步等待其他几个线程全部异步执行完成后再执行（CountDownLatch）
     */
    private static void demo4() {
        CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行…… ……");
        //第一个子线程执行
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es1.shutdown();// 内部使用interrupt,所以该方法会等线程执行完后再结束线程池

        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
    }

    /**
     * 3.1  CountDownLatch模拟并发
     */
    private static void demo5(){
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
        }
    }
    /**
     * 3.2  CountDownLatch模拟并发
     */
    static class CountRunnable implements Runnable {
        private CountDownLatch countDownLatch;
        public CountRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                synchronized (countDownLatch) {
                    /*** 每次减少一个容量*/
                    countDownLatch.countDown();
                    System.out.println("thread counts = " + (countDownLatch.getCount()));
                }
                countDownLatch.await();
                System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 4.cyclicbarrier 三个运动员各自准备，等到三个人都准备好后，再一起跑
     */
    private static void demo6() {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName='A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + " is preparing for time: " + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(rN + " is prepared, waiting for others");
                        cyclicBarrier.await(); // 当前运动员准备完毕，等待别人准备好
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + " starts running"); // 所有运动员都准备好了，一起开始跑
                }
            }).start();
        }
    }

    /**
     * 将子线程的数据回传给主线程
     */
    private static void demo7() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(3000);
                int result = 0;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };
        // first method
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // second method
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        Future future = es2.submit(callable);
        try {
            System.out.println("Before future.get()");
            System.out.println("Result: " + future.get());
            System.out.println("After future.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 工具
     * @param threadName
     */
    private static void printNumber(String threadName) {
        int i=0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }

    public static void main(String[] args) {
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
        demo7();
    }
}
