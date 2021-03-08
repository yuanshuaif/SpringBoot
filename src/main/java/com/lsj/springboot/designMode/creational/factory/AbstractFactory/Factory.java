package com.lsj.springboot.designMode.creational.factory.AbstractFactory;

/**
 * Created by 10326 on 2019/4/21.
 */
public interface Factory {

    Car newCarInstance();

    Plane newPlaneInstance();

}
