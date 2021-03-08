package com.lsj.springboot.designMode.creational.factory.AbstractFactory;

/**
 * Created by 10326 on 2019/4/21.
 */
public class FordPlane implements Plane {
    @Override
    public void run() {
        System.out.println("福特起飞啦");
    }
}
