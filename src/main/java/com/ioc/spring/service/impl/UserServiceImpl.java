package com.ioc.spring.service.impl;

import com.ioc.spring.annotation.IocResource;
import com.ioc.spring.annotation.IocService;
import com.ioc.spring.service.IOrderService;
import com.ioc.spring.service.IUserService;

@IocService(name = "user")
public class UserServiceImpl implements IUserService {

    @IocResource(name = "order")
    private IOrderService orderService;

    public String findOrder(String username) {
        return orderService.findOrder(username);
    }

}
