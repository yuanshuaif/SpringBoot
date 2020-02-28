package com.lsj.springboot.Util.MuiltThread.manyToMany;


import com.lsj.springboot.Util.MuiltThread.manyToMany.entity.ValueObject;

/**
 * Created by 10326 on 2019/5/12.
 * 生产者
 */
public class P {
    private String lock;
    public P(String lock){
        this.lock = lock;
    }
    public void produce(){
        try {
            synchronized (lock){
                while(!"".equals(ValueObject.value)){
                    System.out.println("生产者wait");
                    lock.wait();
                }
                String value =  System.currentTimeMillis() + "";
                System.out.println("set的值是：" + value);
                ValueObject.value = value;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
