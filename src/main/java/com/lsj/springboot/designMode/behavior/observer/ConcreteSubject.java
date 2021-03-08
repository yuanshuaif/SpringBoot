package com.lsj.springboot.designMode.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10326 on 2019/4/14.
 * 观察者模式：对象之间存在一对多的情况，一个对象状态发生改变，依赖它的其他对象会收到通知并自动更新。
 * 类似于：发布订阅模式
 * 具体的被观察者（主题）：每个被观察者，都可以将观察者的引用放到一个集合中。增加、删除观察者数量、通知
 */
public class ConcreteSubject implements Subject {

    List<Observer> list = new ArrayList<>();

    public void addPerson(Observer observer){
        list.add(observer);
    }

    public void removePerson(Observer observer){
        list.remove(observer);
    }

    public void notify(String msg){
        list.forEach(observer -> {
            observer.getMessage(msg);
        });
    }
}
