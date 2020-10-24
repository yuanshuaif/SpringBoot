package com.lsj.springboot.Util.MuiltThread.waitNotify;

import com.lsj.springboot.Util.MuiltThread.waitNotify.thread.ThreadC;
import com.lsj.springboot.Util.MuiltThread.waitNotify.thread.ThreadP;

/**
 * Created by 10326 on 2019/5/12.
 * 多对多的生产者消费者——操作值
 */
public       class Run {
    /**
     * 运行结果 set、get循环输出
     * @param args
     */
    public static void main (String args[]){
        String lock = "";
        P p = new P(lock);
        C c = new C(lock);
        ThreadP[] threadPs = new ThreadP[2];
        ThreadC[] threadCs = new ThreadC[2];
        for(int i = 0; i < 2; i++){
            threadPs[i] = new ThreadP(p);
            threadPs[i].setName("生产者" + (i + 1));
            threadCs[i] = new ThreadC(c);
            threadCs[i].setName("消费者" + (i + 1));
            threadPs[i].start();
            threadCs[i].start();

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for(int i = 0; i <threads.length; i++){
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }
    }
}
