package com.lsj.springboot.designMode.structural.decorate;

/**
 * Created by 10326 on 2019/8/18.
 * 4.具体装饰类
 */
public class ManDecoratorA extends Decorate {

    public ManDecoratorA(Person person) {
        super(person);
    }

    public void eat(){
        person.eat();
        reEat();
    }

    public void reEat() {
        System.out.println("再吃一顿饭A");
    }
}
