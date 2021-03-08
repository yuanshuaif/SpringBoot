package com.lsj.springboot.designMode.structural.bridge;

import com.lsj.springboot.designMode.structural.bridge.bridge.AbstractBridge;
import com.lsj.springboot.designMode.structural.bridge.bridge.RefinedAbstractBridge;
import com.lsj.springboot.designMode.structural.bridge.service.impl.TargetServiceImpl1;

/**
 * Created by 10326 on 2019/8/25.
 * 桥接模式分为抽象部分和实现部分
 */
public class test {

    public static void main(String[] args){
        AbstractBridge abstractBridge = new RefinedAbstractBridge();
        abstractBridge.setImplementor(new TargetServiceImpl1());
        abstractBridge.operation();
    }

}
