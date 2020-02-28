package com.lsj.springboot.springEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/11/17.
 * 3.事件的监听者
 * ApplicationListener<E extends ApplicationEvent> 接口是由 Spring 提供的事件订阅者必须实现的接口，
 * 我们一般把该 Service 关心的事件类型作为泛型传入。
 * 处理事件，通过 event.getSource() 即可拿到事件的具体内容，在本例中便是用户的姓名。
 * 服务必须交给 Spring 容器托管。
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("邮件服务接到通知，给 " + userRegisterEvent.getSource() + " 发送邮件...");
    }
}
