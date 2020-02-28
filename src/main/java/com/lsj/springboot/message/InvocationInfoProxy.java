package com.lsj.springboot.message;

/**
 * Created by 10326 on 2019/11/17.
 * 线程变量
 */
public class InvocationInfoProxy {

    private static final ThreadLocal<InvocationInfo> threadLocal = new ThreadLocal() {
        protected InvocationInfo initialValue() {
            return new InvocationInfo();
        }
    };

    public static String getLocale() {
        return ((InvocationInfo)threadLocal.get()).locale;
    }

    public static void setLocale(String locale) {
        ((InvocationInfo)threadLocal.get()).locale = locale;
    }

}
