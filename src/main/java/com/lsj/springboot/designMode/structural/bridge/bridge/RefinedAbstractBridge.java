package com.lsj.springboot.designMode.structural.bridge.bridge;

import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/8/25.
 */
@Service
public class RefinedAbstractBridge extends AbstractBridge {
    @Override
    public void operation(){
        super.operation();
        System.out.println("我是桥接类！");
    }
}
