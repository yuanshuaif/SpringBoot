package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 加权轮询
 */
public class WeightRound {
    static Servers servers = new Servers();

    static int index;

    public static String go() {
        List<String> ipList = new ArrayList();
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            for (int i = 0; i < item.getValue(); i++) {
                ipList.add(item.getKey());
            }
        }
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        int number = (index++) % allWeight;
        return ipList.get(number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

    public static String go1() {
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        int number = (index++) % allWeight + 1;
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            if (item.getValue() > number) {
                return item.getKey();
            }
            number -= item.getValue();
        }
        return "";
    }
}
