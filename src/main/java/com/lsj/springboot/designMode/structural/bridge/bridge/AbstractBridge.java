package com.lsj.springboot.designMode.structural.bridge.bridge;

import com.lsj.springboot.designMode.structural.bridge.service.ITargetService;

/**
 * Created by 10326 on 2019/8/25.
 * 抽象部分
 */
public abstract class AbstractBridge {

    private ITargetService iTargetService;

    public void  setImplementor(ITargetService iTargetService){
        this.iTargetService = iTargetService;
    }

    public void operation(){
        iTargetService.operation();
    }
}
