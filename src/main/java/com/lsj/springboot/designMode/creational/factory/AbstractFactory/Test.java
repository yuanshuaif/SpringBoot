package com.lsj.springboot.designMode.creational.factory.AbstractFactory;

/**
 * Created by 10326 on 2019/4/21.
 * 抽象工厂模式：一个工厂创建多种产品
 */
public class Test {
    public static void main(String args[]){
        Factory factory = new BenzFactory();
        Car car = factory.newCarInstance();
        car.run();
        car.stop();
        Plane plane = factory.newPlaneInstance();
        plane.run();
    }
}
