package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 1.2加权随机
 * 构建一个服务器的List，如果A服务器的权重是2，那么往List里面Add两次A服务器，如果B服务器的权重是7，那么我往List里面Add7次B服务器，
 * 以此类推，然后再生成一个随机数，随机数的上限就是权重的总和，也就是List的Size
 */
public class WeightRandom {
    static Servers servers = new Servers();
    static Random random = new Random();

    public static String go() {
        List<String> ipList = new ArrayList();
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            for (int i = 0; i < item.getValue(); i++) {
                ipList.add(item.getKey());
            }
        }
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        int number = random.nextInt(allWeight);
        return ipList.get(number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go1());
        }
    }

    /*如果A服务器的权重是2，B服务器的权重是7，C服务器的权重是1：
    如果我生成的随机数是1，那么落到A服务器，因为1<=2（A服务器的权重）；
    如果我生成的随机数是5，那么落到B服务器，因为5>2（A服务器的权重），5-2（A服务器的权重）=3，3<=7（B服务器的权重）；
    如果我生成的随机数是10，那么落到C服务器，因为10>2（A服务器的权重），10-2（A服务器的权重）=8，8>7（B服务器的权重），8-7（B服务器的权重）=1， 1<=1（C服务器的权重）。
    */
    public static String go1() {
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        int number = random.nextInt(allWeight);
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            if (item.getValue() > number) {
                return item.getKey();
            }
            number -= item.getValue();
        }
        return "";
    }
}
