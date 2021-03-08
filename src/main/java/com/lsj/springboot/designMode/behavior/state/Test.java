package com.lsj.springboot.designMode.behavior.state;

/**
 * Created by 10326 on 2019/10/13.
 * 共享状态的状态模式
 */
public class Test {

    public static void main(String[] args){
        Switch s1 = new Switch("开关1");
        Switch s2 = new Switch("开关2");
        s1.off();
        s2.off();
        s1.on();
        s2.on();
    }

}
