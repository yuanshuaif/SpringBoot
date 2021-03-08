package com.lsj.springboot.designMode.behavior.observer;

/**
 * Created by 10326 on 2019/4/14.
 * 被观察者接口(注册发布者)
 */
public interface Subject {

    public void addPerson(Observer observer);

    public void removePerson(Observer observer);

    public void notify(String msg);
}
