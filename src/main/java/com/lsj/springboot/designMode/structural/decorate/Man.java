package com.lsj.springboot.designMode.structural.decorate;

/**
 * Created by 10326 on 2019/8/18.
 * 2.具体组件（被修饰者）
 */
public class Man implements Person{

    @Override
    public void eat() {
        System.out.println("男人在吃饭");
    }

}
