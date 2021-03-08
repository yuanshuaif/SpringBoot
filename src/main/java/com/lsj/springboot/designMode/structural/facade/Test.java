package com.lsj.springboot.designMode.structural.facade;

public class Test {
    public static void main(String[] args){
        Facade facade = new Facade();
        facade.dosomethingA();
        facade.dosomethingB();
        facade.dosomethingC();
    }
}
