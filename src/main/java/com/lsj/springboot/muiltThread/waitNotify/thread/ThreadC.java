package com.lsj.springboot.muiltThread.waitNotify.thread;


import com.lsj.springboot.muiltThread.waitNotify.C;

/**
 * Created by 10326 on 2019/5/12.
 */
public class ThreadC extends Thread {

    private C c;
    public ThreadC(C c){
        this.c = c;
    }

    public void run(){
        while (true){
            c.custom();
        }
    }
}
