package com.lsj.springboot.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 10326 on 2021/10/6.
 */
public class CustomClassLoader extends ClassLoader{
    private static final String CLASS_FILE_SUFFIX = ".class";

    //AppClassLoader的父类加载器
    private ClassLoader extClassLoader;

    public CustomClassLoader(){
        ClassLoader j = String.class.getClassLoader();
        if (j == null) {
            j = getSystemClassLoader();
            while (j.getParent() != null) {
                j = j.getParent();
            }
        }
        this.extClassLoader = j ;
    }

    protected Class<?> loadClass(String name, boolean resolve){

        Class cls = null;
        cls = findLoadedClass(name);
        if (cls != null){
            return cls;
        }
        //获取ExtClassLoader
        ClassLoader extClassLoader = getExtClassLoader() ;
        //确保自定义的类不会覆盖Java的核心类
        try {
            cls = extClassLoader.loadClass(name);
            if (cls != null){
                return cls;
            }
        }catch (ClassNotFoundException e ){

        }
        cls = findClass(name);
        return cls;
    }

    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);
    }

    private byte[] loadClassData(String className) {
        // 读取Class文件呢
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+CLASS_FILE_SUFFIX);
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        // 写入byteStream
        int len =0;
        try {
            while((len=is.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换为数组
        return byteSt.toByteArray();
    }

    public ClassLoader getExtClassLoader(){
        return extClassLoader;
    }
}
