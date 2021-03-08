package com.lsj.springboot.designMode.structural.bridge.bridge;

/**
 * Created by 10326 on 2019/8/25.
 */
public class RefinedAbstractBridge extends AbstractBridge {
    @Override
    public void operation(){
        super.operation();
        System.out.println("我是桥接类！");
    }
}
