package com.lsj.springboot.Util.MuiltThread.manyToMany.thread;


import com.lsj.springboot.Util.MuiltThread.manyToMany.P;

/**
 * Created by 10326 on 2019/5/12.
 */
public class ThreadP extends Thread {

    private P p;
    public ThreadP(P p){
        this.p = p;
    }

    public void run(){
        while(true){
            p.produce();
        }
    }
}
