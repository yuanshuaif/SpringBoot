package com.lsj.springboot.designMode.structural.bridge.service.impl;

import com.lsj.springboot.designMode.structural.bridge.service.ITargetService;
import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/8/25.
 */
@Service
public class TargetServiceImpl2 implements ITargetService {
    @Override
    public void operation() {
        System.out.println("我是目标接口实现类2");
    }
}
