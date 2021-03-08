package com.lsj.springboot.designMode.behavior.observer;

/**
 * Created by 10326 on 2019/4/14.
 * ConcreteObserver:观察者的具体实现
 */
public class ConcreteObserver2 implements Observer {

    private static final String NAME = "ConcreteObserver2";

    @Override
    public void getMessage(String msg) {
        System.out.println(NAME + msg);
    }
}
