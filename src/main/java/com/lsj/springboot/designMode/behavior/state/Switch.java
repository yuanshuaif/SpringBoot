package com.lsj.springboot.designMode.behavior.state;

/**
 * Created by 10326 on 2019/10/13.
 * 环境类
 */
public class Switch {
    private static SwitchState state;// 共享状态的状态模式核心，环境类所拥有的的状态类是static
    private String name;

    public Switch(String name) {
        this.state = new OnState();// 开关默认的状态
        this.name = name;
    }

    public void setState(SwitchState state) {
        this.state = state;
    }

    public void on(){
        System.out.print(name);
        state.onState(this);
    }

    public void off(){
        System.out.print(name);
        state.offState(this);
    }

}
