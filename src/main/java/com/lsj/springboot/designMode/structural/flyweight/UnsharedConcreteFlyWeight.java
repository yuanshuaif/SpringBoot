package com.lsj.springboot.designMode.structural.flyweight;

/**
 * Created by 10326 on 2019/8/28.
 * 不共享的具体享元类
 */
public class UnsharedConcreteFlyWeight extends AbstractFlyWeight {

    @Override
    public void operate(String extrinsic) {
        System.out.println(extrinsic + "不共享的具体Flyweight");
    }
}
