package com.lsj.springboot.designMode.structural.decorate;

/**
 * Created by 10326 on 2019/8/18.
 * 装饰者模式
 */
public class Test {

    public static void main(String[] args){
       /* Decorate decorateSimple = new Decorate(new Man()) {
            @Override
            public void eat() {
                person.eat();
            }
        };
        decorateSimple.eat();*/

        Decorate decorate = new ManDecoratorB(new ManDecoratorA(new Man()));
        decorate.eat();
    }
}
