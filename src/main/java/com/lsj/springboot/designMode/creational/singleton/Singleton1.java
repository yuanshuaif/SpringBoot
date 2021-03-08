package com.lsj.springboot.designMode.creational.singleton;

/**
 * Created by Administrator on 2019/1/31.
 * 饿汉式
 */
public class Singleton1 {
    // 1. 类加载时创建对象
    private static Singleton1 singleton= new Singleton1();
    // 2. 构造函数私有化
    private Singleton1(){}
    // 3.对外提供获取该类实例的静态方法
    private static Singleton1 newInstance(){
        return singleton;
    }
}
