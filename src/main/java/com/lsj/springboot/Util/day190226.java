package com.lsj.springboot.Util;

/**
 * Created by Administrator on 2019/2/26.
 */
public class day190226 {
    // 0的ascll码：48； A的ascll码：65；a的ascll码是97
    public static void main(String[] args) {
        int a = '1';
        System.out.println(a);


        String str = "+86-12331654321";
        str = str.substring(str.indexOf("-") + 1);
        System.out.println(str);
    }
}
