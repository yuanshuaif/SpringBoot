package com.lsj.springboot.muiltThread;

/**
 * Created by 10326 on 2019/4/21.
 *  1.线程间的可见性；2.防止指令重排序；3.不保证原子性（synchronized 组合保证原子性）
 */
public class Volatile extends Thread {

    volatile public static int count;

    @Override
    public void run(){
       add();
    }

    synchronized private static void add(){
        for(int i = 0; i < 1000; i++){
            count++;
        }
        System.out.println("count=" + count);
    }

    public static void main(String args[]){
        Volatile[] aVolatile = new Volatile[20];
        for(int i = 0; i < 20; i++){
            aVolatile[i] = new Volatile();
        }

        for(int i = 0; i < 20; i++){
            aVolatile[i].start();
        }
    }

}
