package com.lsj.springboot.JDK8.LambdaPackage;

import com.lsj.springboot.JDK8.SreamPackage.PersonModel;

/**
 * Created by 10326 on 2019/4/20.
 */
public class FilterClass1 implements Filter {

    private static String name = "yuanshuai";

    @Override
    public boolean match(PersonModel personModel) {
        return name.equals(personModel.getName());
    }

    public void defaultMethod(){
        System.out.println("你好,我是重写者FilterClass1()");
    }

}
