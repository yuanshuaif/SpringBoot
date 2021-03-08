package com.lsj.springboot.designMode.behavior.memento;

/**
 * Created by 10326 on 2020/5/2.
 * 原发器
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }

}
