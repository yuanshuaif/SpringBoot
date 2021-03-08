package com.lsj.springboot.designMode.creational.singleton;

/**
 * Created by 10326 on 2019/4/21.
 */
public class Test {
    public static void main(String args[]){
        Singleton4 singleton1 = Singleton4.newInstance();
        Singleton4 singleton2 = Singleton4.newInstance();
        System.out.println(singleton1 == singleton2);
    }
}
