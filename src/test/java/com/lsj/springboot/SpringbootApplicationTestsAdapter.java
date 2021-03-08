package com.lsj.springboot;

import com.lsj.springboot.designMode.structural.adapter.classAdapter.TargetInterface;
import com.lsj.springboot.designMode.structural.adapter.objectAdapter.TargetInterface1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 适配器模式测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTestsAdapter {

    @Autowired
    private TargetInterface target;
    @Autowired
    private TargetInterface1 target1;

	@Test
	public void testAdatper() {
        target.targetMethod();
	}
    @Test
    public void testAdatper1() {
        target1.targetMethod();
    }

}
