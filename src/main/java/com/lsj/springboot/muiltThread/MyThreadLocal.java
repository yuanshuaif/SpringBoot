package com.lsj.springboot.muiltThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 10326 on 2020/2/1.
 */
public class MyThreadLocal {

    /**
     * 使用线程变量解决SimpleDateFomat的线程安全问题
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();

    public DateFormat getDateFormat() {
        DateFormat df = threadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            threadLocal.set(df);
        }
        return df;
    }

    public static class MyRunnable implements Runnable {
        private MyThreadLocal dateFormatDemo;
        public MyRunnable(MyThreadLocal dateFormatDemo) {
            this.dateFormatDemo = dateFormatDemo;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" 当前时间："+dateFormatDemo.getDateFormat().format(new Date()));
        }
    }

    public static void main(String[] args) {
        MyThreadLocal formatDemo = new MyThreadLocal();

        MyRunnable myRunnable1 = new MyRunnable(formatDemo);
        MyRunnable myRunnable2 = new MyRunnable(formatDemo);
        MyRunnable myRunnable3 = new MyRunnable(formatDemo);

        Thread thread1= new Thread(myRunnable1);
        Thread thread2= new Thread(myRunnable2);
        Thread thread3= new Thread(myRunnable3);
        thread1.start();
        thread2.start();
        thread3.start();

       /* String str1 = "what";
        String str2 = str1 + " a nice day";
        System.out.println("what a nice day".equals(str2));
        System.out.println("what a nice day" == str2);*/

       /* String str1 = "what a nice day";
        String str2 = new String("what a nice day");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);*/

      /*  String str1 = "what";
        String str2 = str1.concat(" a nice day");
        System.out.println("what a nice day".equals(str2));
        System.out.println("what a nice day" == str2);
        System.out.println("what a nice day"==str2.intern());
//        System.out.println(str2.intern() == "what a nice day");
        String str = new StringBuilder().append(str1).append(" a nice day").toString();*/
    }
}
