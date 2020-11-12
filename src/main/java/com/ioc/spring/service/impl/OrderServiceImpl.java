package com.ioc.spring.service.impl;

import com.ioc.spring.annotation.IocResource;
import com.ioc.spring.annotation.IocService;
import com.ioc.spring.service.IOrderService;
import com.ioc.spring.service.IUserService;

@IocService(name = "order")
public class OrderServiceImpl implements IOrderService {

    @IocResource(name = "user")
    private IUserService userService;

    public String findOrder(String username) {
        return "用户" + username + "的订单编号是:1001";
    }

}
