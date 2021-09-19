package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.*;

/**
 * 负载均衡的算法：随机、加权随机、轮询、加权轮询、平滑加权轮询、hash、最小压力
 */
public class Servers {
    // 随机算法、轮询算法
    public static List<String> list = new ArrayList() {
        {
            add("192.168.1.1");
            add("192.168.1.2");
            add("192.168.1.3");
        }
    };
    // 加权随机算法、加权轮询算法
    public static Map<String, Integer> map = new LinkedHashMap() {
        {
            put("192.168.1.1", 2);
            put("192.168.1.2", 7);
            put("192.168.1.3", 1);
        }
    };
    // 平滑加权轮询
    public static Map<String, Server> serverMap = new LinkedHashMap() {
        {
            put("192.168.1.1", new Server(5,5,"192.168.1.1"));
            put("192.168.1.2", new Server(1,1,"192.168.1.2"));
            put("192.168.1.3", new Server(1,1,"192.168.1.3"));
        }
    };

}
