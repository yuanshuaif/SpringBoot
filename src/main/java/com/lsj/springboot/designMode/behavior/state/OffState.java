package com.lsj.springboot.designMode.behavior.state;

/**
 * Created by 10326 on 2019/10/13.
 */
public class OffState implements SwitchState {
    @Override
    public void onState(Switch s) {
        System.out.println("打开");
        s.setState(new OnState());

    }

    @Override
    public void offState(Switch s) {
        System.out.println("已经关闭");
    }
}
