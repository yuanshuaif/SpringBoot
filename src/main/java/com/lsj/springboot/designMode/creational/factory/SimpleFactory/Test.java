package com.lsj.springboot.designMode.creational.factory.SimpleFactory;

/**
 * Created by 10326 on 2019/4/16.
 * 简单工厂模式：1）一个接口，2）多个实例，3）一个工厂。按照不同的类型来实例化抽象的接口
 * （不是设计模式）
 */
public class Test {

    public static void main(String args[]){
        Car car = CarFactory.newInstance("Benz");
        car.run();
        car.stop();
    }

}
