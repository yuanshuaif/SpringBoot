package com.lsj.springboot.jdk8.lambdaPackage;

import com.lsj.springboot.jdk8.sreamPackage.PersonModel;

/**
 * Created by 10326 on 2019/4/20.
 */
public interface Filter {

    boolean match(PersonModel personModel);

    /*1.8为了向下兼容，1.7中的实现类不用实现接口中的方法*/
    // 该方法属于类
    static void staticMethod(){
        System.out.println("你好,我是staticMethod()");
    }

    default void defaultMethod(){
        System.out.println("你好,我是defaultMethod()");
    }

}
