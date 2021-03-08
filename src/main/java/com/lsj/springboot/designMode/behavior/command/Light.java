package com.lsj.springboot.designMode.behavior.command;

/**
 * Created by 10326 on 2019/10/13.
 * 接收者对象Receiver
 */
public class Light {

    /**
     * 开灯方法
     */
    public void lightOn() {
        System.out.println("灯打开了！！");
    }

    /**
     * 关灯方法
     */
    public void lightOff() {
        System.out.println("灯关上了！！");
    }

}
