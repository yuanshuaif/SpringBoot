package com.lsj.springboot.designMode.structural.proxy.staticProxy;

/**
 * Created by 10326 on 2019/4/21.
 * 静态代理模式
 * 1.代理类和被代理都继承同一个接口
 * 2.代理类里需要注入公共的接口
 * 3.代理类的方法里调用被代理类的方法
 */
public class Test {
    public static void main(String args[]) {
        ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
        proxyInterface.marry();
    }
}
