package com.lsj.springboot.designMode.behavior.observer;

/**
 * Created by 10326 on 2019/4/14.
 * 设计模式——观察者模式
 */
public class Test {

    public static void main(String args[]){
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver2 concreteObserver2 = new ConcreteObserver2();
        ConcreteObserver1 concreteObserver1 = new ConcreteObserver1();
        /*注册（订阅）*/
        concreteSubject.addPerson(concreteObserver2);
        concreteSubject.addPerson(concreteObserver1);
        /*通知*/
        concreteSubject.notify("：nihao");

    }
}
