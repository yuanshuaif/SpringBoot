package com.lsj.springboot.designMode.behavior.visitor;

/**
 * Created by 10326 on 2020/5/4.
 */
public class Test {

    public static void main(String[] args){
        // 摩拜、共享单车
        Element element = new ProjectElement("mobike", "share bicycle");
        element.accept(new CTOVisitor());
        element.accept(new CEOVisitor());
    }

}
