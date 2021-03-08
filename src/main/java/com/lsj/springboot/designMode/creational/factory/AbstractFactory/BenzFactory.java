package com.lsj.springboot.designMode.creational.factory.AbstractFactory;

/**
 * Created by 10326 on 2019/4/21.
 */
public class BenzFactory implements Factory {
    @Override
    public Car newCarInstance() {
        return new Benz();
    }

    @Override
    public Plane newPlaneInstance() {
        return new BenzPlane();
    }
}
