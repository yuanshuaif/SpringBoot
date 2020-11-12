package com.ioc.spring.test;

import com.ioc.spring.context.SpringContext;
import com.ioc.spring.service.IUserService;

public class SpringIocTest {
    public static void main(String[] args)throws Exception {
        String path = "com.ioc.spring.service.impl";
        SpringContext context = new SpringContext(path);
        IUserService userService = (IUserService) context.getBean("user");
        System.out.println(userService.findOrder("lyl"));
    }
}
