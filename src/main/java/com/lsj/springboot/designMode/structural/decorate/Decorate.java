package com.lsj.springboot.designMode.structural.decorate;

/**
 * Created by 10326 on 2019/8/18.
 * 3.抽象修饰类
 */
public abstract class Decorate implements Person{

    public Person person;

    public Decorate(Person person){
        this.person = person;
    }

    public abstract void eat();
}
