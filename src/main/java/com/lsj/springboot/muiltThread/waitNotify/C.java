package com.lsj.springboot.muiltThread.waitNotify;


import com.lsj.springboot.muiltThread.waitNotify.entity.ValueObject;

/**
 * Created by 10326 on 2019/5/12.
 * 循环；notifyAll
 *
 * 消费者
 */
public class C {
    private String lock;
    public C(String lock){
        this.lock = lock;
    }
    public void custom(){
        try {
            synchronized (lock){
                while("".equals(ValueObject.value)){
                    System.out.println("消费者wait");
                    lock.wait();
                }
                System.out.println("get的值是：" + ValueObject.value);
                ValueObject.value = "";
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
