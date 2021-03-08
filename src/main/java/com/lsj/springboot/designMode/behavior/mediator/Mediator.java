package com.lsj.springboot.designMode.behavior.mediator;

/**
 * Created by 10326 on 2019/10/13.
 * 抽象中介者
 */
public abstract class Mediator {
    public abstract void contact(String content, Colleague coll);
}
