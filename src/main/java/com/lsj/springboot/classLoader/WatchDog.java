package com.lsj.springboot.classLoader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by 10326 on 2021/10/6.
 */
public class WatchDog implements Runnable {

    private Map<String,FileDefine> fileDefineMap;

    public WatchDog(Map<String,FileDefine> fileDefineMap){
        this.fileDefineMap = fileDefineMap;
    }

    @Override
    public void run() {
        File file = new File(FileDefine.WATCH_PACKAGE);
        File[] files = file.listFiles();
        for (File watchFile : files){
            long newTime = watchFile.lastModified();
            FileDefine fileDefine = fileDefineMap.get(watchFile.getName());
            long oldTime = fileDefine.getLastDefine();
            //如果文件被修改了,那么重新生成累加载器加载新文件
            if (newTime!=oldTime){
                fileDefine.setLastDefine(newTime);
                loadMyClass();
            }
        }
    }

    public void loadMyClass(){
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> cls = customClassLoader.loadClass("com.example.watchfile.Test",false);
            Object test = cls.newInstance();
            Method method = cls.getMethod("test");
            method.invoke(test);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
