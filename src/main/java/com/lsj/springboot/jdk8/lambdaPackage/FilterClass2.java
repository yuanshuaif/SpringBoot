package com.lsj.springboot.jdk8.lambdaPackage;

import com.lsj.springboot.jdk8.sreamPackage.PersonModel;

/**
 * Created by 10326 on 2019/4/20.
 */
public class FilterClass2 implements Filter {

    private static String phone = "12081273891";

    @Override
    public boolean match(PersonModel personModel) {
        return phone.equals(personModel.getPhone());
    }
}
