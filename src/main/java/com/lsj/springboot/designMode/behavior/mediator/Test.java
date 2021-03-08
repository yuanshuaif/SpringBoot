package com.lsj.springboot.designMode.behavior.mediator;

/**
 * Created by 10326 on 2019/10/13.
 * 中介者模式：将网状结构转化成型状结构；将对象之间的多对多的关系转化成1对多的关系
 */
public class Test {

    public static void main(String[] args){
        // 定义中介者
        ConcreteMediator mediator = new ConcreteMediator();
        // 定义具体同事类
        ColleagueA colleagueA = new ColleagueA("张三", mediator);
        ColleagueB colleagueB = new ColleagueB("李四", mediator);
        // 中介者知晓每一个具体的Colleague类
        mediator.setCollA(colleagueA);
        mediator.setCollB(colleagueB);
        colleagueA.contact("我是A，我要和同事B说说工作的事情");
        colleagueB.contact("我是B,我下午有时间,下午商量吧");
    }

}
