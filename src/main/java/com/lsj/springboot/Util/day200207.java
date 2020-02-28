package com.lsj.springboot.Util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by 10326 on 2020/2/6.
 */
public class day200207 {

    public static void main(String[] args) throws InterruptedException {
        // 堆中的对象放入常量池并返回——与堆中的数据比较 返回ture
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        // java、void、main、基本类型  常量池中固定字段 ； 常量池中的数据与堆中的数据比较所以返回false
        String str2 = new StringBuilder("in").append("t").toString();
        System.out.println(str2.intern() == str2);
    }
}
