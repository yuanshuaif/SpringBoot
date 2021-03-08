package com.lsj.springboot.designMode.structural.proxy.dynamicProxy.CGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/1/31.
 * 0.实现MethodIntecptor接口，并重写其方法
 */
public class CGLIBProxy  implements MethodInterceptor{
    /**
     * 1.获取CGLIB对象
     * @param cla
     * @return
     */
    public Object getCGLIBProxy(Class cla){
        // 1.1 使用Enhancer增强对象
        Enhancer enhancer = new Enhancer();
        // 1.2 设置增强类型
        enhancer.setSuperclass(cla);
        // 1.3 指定代理逻辑类
        enhancer.setCallback(this);
        // 1.4 返回CGLIB对象
        return enhancer.create();
    }

    /**
     * 2.实现代理逻辑
     * @param proxy
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调度真实对象前的逻辑");
        methodProxy.invokeSuper(proxy, objects);
        System.out.println("调度真实对象后的逻辑");
        return null;
    }
}
