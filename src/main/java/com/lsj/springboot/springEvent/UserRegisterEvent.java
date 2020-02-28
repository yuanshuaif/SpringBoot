package com.lsj.springboot.springEvent;

import org.springframework.context.ApplicationEvent;

/**
 * Created by 10326 on 2019/11/17.
 * 1.用户注册的事件
 */
public class UserRegisterEvent extends ApplicationEvent {
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
