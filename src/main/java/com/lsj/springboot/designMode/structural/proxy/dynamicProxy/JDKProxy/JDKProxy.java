package com.lsj.springboot.designMode.structural.proxy.dynamicProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2019/1/31.
 * 0.代理逻辑类需要实现InvocatioHanlder接口，并重写invork方法
 */
public class JDKProxy implements InvocationHandler {
    private Object target = null;

    /**
     * 1.建立代理关系
     * Target.getClass().getClassLoader(): 真实对象的类加载器
     * Target.getClass().getInterfaces(): 真实对象实现的接口
     * this: 代理逻辑实现类
     *
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 2.实现代理逻辑
     * @param proxy（代理对象）
     * @param method(方法)
     * @param args（参数）
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调度真实对象前的逻辑");
        method.invoke(target, args);
        System.out.println("调度真实对象后的逻辑");
        return null;
    }
}
