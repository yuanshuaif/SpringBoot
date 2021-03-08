package com.lsj.springboot;

import com.lsj.springboot.designMode.behavior.strategy.Service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 策略模式测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTestsStrategy {

    @Autowired
    private IUserService userService;

	@Test
	public void testSimpleMail() {
        userService.getNameByType("ys1");
	}

}
