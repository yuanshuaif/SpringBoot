package com.lsj.springboot.designMode.creational.factory.FactoryMethod;

/**
 * Created by 10326 on 2019/4/16.
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car newInstance() {
        return new Benz();
    }
}
