package com.lsj.springboot.designMode.creational.factory.SimpleFactory;

/**
 * Created by 10326 on 2019/4/16.
 */
public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("奔驰启动了");
    }

    @Override
    public void stop() {
        System.out.println("奔驰破产了了");
    }
}
