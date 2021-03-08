package com.lsj.springboot.designMode.creational.singleton;

/**
 * Created by Administrator on 2019/1/31.
 * 懒汉模式——线程安全式(双重校验锁)
 * (线程不安全的唯一区别：不添加synchronized字段)
 */
public class Singleton4 {
    // 1.类加载时不创建实例
    private volatile static Singleton4 singleton4;
    // 2.构造函数私有化
    private Singleton4(){}
    // 3.方法加锁实例化对象
    public static Singleton4 newInstance(){
        if(singleton4 != null){
            synchronized (Singleton4.class) {
                if(singleton4 != null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
