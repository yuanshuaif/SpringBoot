package com.lsj.springboot.jdk8.sreamPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 10326 on 2019/4/10.
 */
public class Data {

    private static List<PersonModel> list = new ArrayList<>();

    static{
        PersonModel model1 = new PersonModel("yuanshuai",27,"12381273891");
        PersonModel model2 = new PersonModel("lsj",27,"12081273891");
        PersonModel model3 = new PersonModel("ltj",26,"12982313981");
        PersonModel model4 = new PersonModel("ly",29,"12389127318");
        PersonModel model5 = new PersonModel("dk",27,"19238917318");
        list = Arrays.asList(new PersonModel[]{model1, model2, model3, model4, model5});
    }

    public static List<PersonModel> getData(){
        return list;
    }

}
