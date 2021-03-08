package com.lsj.springboot.designMode.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10326 on 2020/5/2.
 * 持有者
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

}
