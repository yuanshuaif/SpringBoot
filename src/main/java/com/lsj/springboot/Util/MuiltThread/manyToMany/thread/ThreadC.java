package com.lsj.springboot.Util.MuiltThread.manyToMany.thread;


import com.lsj.springboot.Util.MuiltThread.manyToMany.C;

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
