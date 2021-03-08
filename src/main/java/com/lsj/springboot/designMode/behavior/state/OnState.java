package com.lsj.springboot.designMode.behavior.state;

/**
 * Created by 10326 on 2019/10/13.
 * 具体的打开状态类
 */
public class OnState implements SwitchState {
    @Override
    public void onState(Switch s) {
        System.out.println("已经打开");
    }

    @Override
    public void offState(Switch s) {
        System.out.println("关闭");
        s.setState(new OffState());
    }
}
