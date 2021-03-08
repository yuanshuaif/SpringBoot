package com.lsj.springboot.designMode.structural.proxy.dynamicProxy.JDKProxy;

/**
 * Created by Administrator on 2019/1/31.
 */
public class JDKProxyTest {
  public static void main(String[] args){
      JDKProxy jdkProxy = new JDKProxy();
      HelloWord proxy = (HelloWord) jdkProxy.bind(new HelloWordImpl());
      proxy.sayHelloWord();
  }
}
