package com.lsj.springboot.designMode.behavior.visitor;

/**
 * Created by 10326 on 2020/5/4.
 */
public interface Element {
    void accept(Visitor visitor);
}
