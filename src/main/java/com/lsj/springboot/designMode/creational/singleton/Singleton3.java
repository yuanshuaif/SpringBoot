package com.lsj.springboot.designMode.creational.singleton;

/**
 * Created by 10326 on 2019/4/16.
 * 静态内部类
 */
public class Singleton3 {
    private Singleton3(){

    }
    private static class SingletonFactory{
        private static final Singleton3 SINGLETON = new Singleton3();
    }

    public static Singleton3 newInstance(){
        return SingletonFactory.SINGLETON;
    }
}
