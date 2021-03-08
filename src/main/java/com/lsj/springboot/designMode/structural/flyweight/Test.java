package com.lsj.springboot.designMode.structural.flyweight;

/**
 * Created by 10326 on 2019/8/28.
 *
 */
public class Test {

    public static void main (String[] args){
        AbstractFlyWeight flyweightX = FlyWeightFactory.getFlyWeight("X");
        flyweightX.operate("asd");

        AbstractFlyWeight flyweightY = FlyWeightFactory.getFlyWeight("Y");
        flyweightY.operate("sfg");

        AbstractFlyWeight flyweightZ = FlyWeightFactory.getFlyWeight("Z");
        flyweightZ.operate("auid");

        AbstractFlyWeight flyweightReX = FlyWeightFactory.getFlyWeight("X");
        flyweightReX.operate("iouui");// 与第一个是同一个享元对象，但是外部变量不同，所以有不同的表现

        AbstractFlyWeight unsharedFlyweight = new UnsharedConcreteFlyWeight();
        unsharedFlyweight.operate("X");
    }

}
