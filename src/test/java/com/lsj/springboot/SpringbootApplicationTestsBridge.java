package com.lsj.springboot;

import com.lsj.springboot.designMode.structural.adapter.classAdapter.TargetInterface;
import com.lsj.springboot.designMode.structural.adapter.objectAdapter.TargetInterface1;
import com.lsj.springboot.designMode.structural.bridge.bridge.Bridge;
import com.lsj.springboot.designMode.structural.bridge.service.ITargetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 适配器模式测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTestsBridge {

    @Autowired
    private Bridge bridge;
    @Autowired
    @Qualifier("targetServiceImpl1")
    private ITargetService targetService;

	@Test
	public void testAdatper() {
        bridge.setImplementor(targetService);
        bridge.operation();
	}

}
