package com.lsj.springboot.Util.arithmetic.day200611;

public class Person {

    private String name;
    private int workingLife;

    public Person(){

    }

    public Person(String name, int workingLife){
        this.name = name;
        this.workingLife = workingLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkingLife() {
        return workingLife;
    }

    public void setWorkingLife(int workingLife) {
        this.workingLife = workingLife;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", workingLife='" + workingLife + '\'' +
                '}';
    }
}
