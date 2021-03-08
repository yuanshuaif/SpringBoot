package com.lsj.springboot.designMode.behavior.chain;

/**
 * Created by 10326 on 2019/8/26.
 * 抽象责任对象
 */
public abstract class AbstractTarget {

    public AbstractTarget netTarget;

    public String name;

    public AbstractTarget getNetTarget() {
        return netTarget;
    }

    public void setNetTarget(AbstractTarget netTarget) {
        this.netTarget = netTarget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void operate();
}
