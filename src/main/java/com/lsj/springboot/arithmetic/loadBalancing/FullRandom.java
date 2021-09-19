package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.Random;

/**
 * 1.1随机算法
 */
public class FullRandom {
    static Servers servers = new Servers();
    static Random random = new Random();

    public  static String  go() {
        // 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
        int number = random.nextInt(servers.list.size());
        return servers.list.get(number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }
}
