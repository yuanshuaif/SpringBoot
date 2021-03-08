package com.lsj.springboot.designMode.creational.factory.AbstractFactory;

/**
 * Created by 10326 on 2019/4/21.
 */
public class FordFactory implements Factory {
    @Override
    public Car newCarInstance() {
        return new Ford();
    }

    @Override
    public Plane newPlaneInstance() {
        return new FordPlane();
    }
}
