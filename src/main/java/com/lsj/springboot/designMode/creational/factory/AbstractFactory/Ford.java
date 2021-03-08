package com.lsj.springboot.designMode.creational.factory.AbstractFactory;

/**
 * Created by 10326 on 2019/4/21.
 */
public class Ford implements Car {
    @Override
    public void run() {
        System.out.println("福特启动了");
    }

    @Override
    public void stop() {
        System.out.println("福特破产了");
    }
}
