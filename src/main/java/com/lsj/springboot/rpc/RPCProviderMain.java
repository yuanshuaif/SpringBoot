package com.lsj.springboot.rpc;

import com.lsj.springboot.rpc.impl.HelloServiceImpl;

/**
 * 启动提供者端的网络侦听和远程调用
 */
public class RPCProviderMain {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        ProviderReflect.provider(service,8083);
    }
}
