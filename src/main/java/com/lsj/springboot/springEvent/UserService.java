package com.lsj.springboot.springEvent;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/11/17.
 * 2.用户注册服务（事件的发布者）
 * ApplicationEventPublisherAware 是由 Spring 提供的用于为 Service 注入 ApplicationEventPublisher 事件发布器的接口，
 * 使用这个接口，我们自己的 Service 就拥有了发布事件的能力。
 * 服务必须交给 Spring 容器托管。
 */
@Service
public class UserService implements ApplicationEventPublisherAware,InitializingBean,DisposableBean,SmartLifecycle {

    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String name) {
        System.out.println("用户：" + name + " 已注册！");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 销毁的方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("发布者销毁了");
    }

    /**
     * 初始化的方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("发布者初始化了");
    }

    /**
     * 所有的bean初始化完成以后会调用该方法，多用于启动任务或其他异步服务
     */
    @Override
    public void start() {
        this.register("xttblog.com");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
