package com.lsj.springboot.designMode.structural.facade;

public class Facade {
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;
    private Subsystem3 subsystem3;
    public Facade(){
        subsystem1 = new Subsystem1();
        subsystem2 = new Subsystem2();
        subsystem3 = new Subsystem3();
    }
    public void dosomethingA(){
        subsystem1.dosomethingA();
    }
    public void dosomethingB(){
        subsystem2.dosomethingB();
    }
    public void dosomethingC(){
        subsystem3.dosomethingC();
    }
}
