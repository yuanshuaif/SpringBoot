package com.lsj.springboot.designMode.behavior.memento;

/**
 * Created by 10326 on 2020/5/2.
 * 备忘录
 */
public class Memento {

    private String state;

    public Memento(){

    }

    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
