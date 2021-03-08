package com.lsj.springboot.designMode.structural.adapter.objectAdapter;

import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/8/18.
 */
@Service
public class Adaptee1 {

    public void targetMethod(){
        System.out.println("适配成功啦！！！");
    }
}
