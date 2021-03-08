package com.lsj.springboot.designMode.structural.adapter.classAdapter;

import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/8/18.
 */
@Service
public class Adapter extends Adaptee implements TargetInterface {

    public void targetMethod(){
        super.oldMethod();
    }

}
