package com.lsj.springboot.classLoader;

/**
 * Created by 10326 on 2021/10/6.
 */
public class FileDefine {
    long lastDefine;
    public static final String WATCH_PACKAGE = "com.lsj.springboot.classLoader";

    public long getLastDefine() {
        return lastDefine;
    }

    public void setLastDefine(long lastDefine) {
        this.lastDefine = lastDefine;
    }
}
