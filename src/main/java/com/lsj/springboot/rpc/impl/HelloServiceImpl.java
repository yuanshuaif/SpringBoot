package com.lsj.springboot.rpc.impl;

import com.lsj.springboot.rpc.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String content) {
        return "hello," + content;
    }
}
