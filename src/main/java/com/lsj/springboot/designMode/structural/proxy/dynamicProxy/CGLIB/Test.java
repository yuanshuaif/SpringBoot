package com.lsj.springboot.designMode.structural.proxy.dynamicProxy.CGLIB;

/**
 * Created by 10326 on 2019/1/31.
 */
public class Test {

    public static void main(String[] args){
        CGLIBProxy CGLIBProxy = new CGLIBProxy();
        HelloWord helloWord = (HelloWord) CGLIBProxy.getCGLIBProxy(HelloWord.class);
        helloWord.sayHelloWord();
    }
}
