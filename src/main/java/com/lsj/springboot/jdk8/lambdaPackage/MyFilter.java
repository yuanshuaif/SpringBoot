package com.lsj.springboot.jdk8.lambdaPackage;

import com.lsj.springboot.jdk8.sreamPackage.PersonModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10326 on 2019/4/20.
 */
public class MyFilter {

    public List<PersonModel> test(List<PersonModel> list, Filter filter){

       List<PersonModel> returnList = new ArrayList<>();

        for(PersonModel person : list){
            if(filter.match(person)){
                returnList.add(person);
            }
        }

        return returnList;

    }
}
