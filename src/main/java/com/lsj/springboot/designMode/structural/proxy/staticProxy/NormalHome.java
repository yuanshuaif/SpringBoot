package com.lsj.springboot.designMode.structural.proxy.staticProxy;

/**
 * Created by 10326 on 2019/4/21.
 */
public class NormalHome implements ProxyInterface{
    @Override
    public void marry() {
        System.out.println("我们结婚啦～");
    }
}
