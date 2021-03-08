package com.lsj.springboot.designMode.creational.singleton;

/**
 * Created by Administrator on 2019/1/31.
 * 懒汉模式——线程安全式
 * (线程不安全的唯一区别：不添加synchronized字段)
 */
public class Singleton2 {
    // 1.类加载时不创建实例
    private static Singleton2 singleton2;
    // 2.构造函数私有化
    private Singleton2(){}
    // 3.方法加锁实例化对象
    public static synchronized Singleton2 newInstance(){
        if(singleton2 != null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
