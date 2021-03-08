package com.lsj.springboot.designMode.behavior.observer;

/**
 * Created by 10326 on 2019/4/14.
 */
public class ConcreteObserver1 implements Observer {

    private static final String NAME = "ConcreteObserver1";

    @Override
    public void getMessage(String msg) {
        System.out.println(NAME + msg);
    }
}
