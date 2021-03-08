package com.lsj.springboot.designMode.behavior.state;

/**
 * Created by 10326 on 2019/10/13.
 * 抽象状态类
 */
public interface SwitchState {
    public void onState(Switch s);
    public void offState(Switch s);
}
