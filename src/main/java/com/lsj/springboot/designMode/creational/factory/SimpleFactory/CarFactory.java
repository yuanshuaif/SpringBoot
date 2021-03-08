package com.lsj.springboot.designMode.creational.factory.SimpleFactory;

/**
 * Created by 10326 on 2019/4/16.
 */
public class CarFactory {

    public static Car newInstance(String type){
        Car c = null;
        if ("Benz".equals(type)) {
            c = new Benz();
        }
        if ("Ford".equals(type)) {
            c = new Ford();
        }
        return c;
    }
}
