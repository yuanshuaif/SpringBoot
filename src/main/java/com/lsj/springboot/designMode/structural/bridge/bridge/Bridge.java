package com.lsj.springboot.designMode.structural.bridge.bridge;

import com.lsj.springboot.designMode.structural.bridge.service.ITargetService;

public interface Bridge {
    void  setImplementor(ITargetService iTargetService);
    void operation();
}
