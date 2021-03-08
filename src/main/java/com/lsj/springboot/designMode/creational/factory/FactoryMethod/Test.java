package com.lsj.springboot.designMode.creational.factory.FactoryMethod;

/**
 * Created by 10326 on 2019/4/16.
 * 工厂方法模式：一个接口、多个实例、一个工厂接口、多个工厂实例（每个工厂实例创建一种产品）,每种类型的工厂创建每种类型的实例
 */
public class Test {
    public static void main(String args[]){
        CarFactory factory = new BenzFactory();
        Car car = factory.newInstance();
        car.run();
        car.stop();
    }
}
