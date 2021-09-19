package com.lsj.springboot.arithmetic.loadBalancing;

/**
 * 轮询
 */
public class FullRound {
    static Servers servers = new Servers();
    static int index;

    public static String go() {
        if (index == servers.list.size()) {
            index = 0;
        }
        return servers.list.get(index++);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }
}
