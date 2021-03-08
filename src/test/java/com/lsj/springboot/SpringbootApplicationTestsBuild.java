package com.lsj.springboot;

import com.lsj.springboot.designMode.creational.build.Build.CarDirector;
import com.lsj.springboot.designMode.creational.build.Entity.Car;
import com.lsj.springboot.designMode.creational.build.Service.CreateCar;
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
public class SpringbootApplicationTestsBuild {

    @Autowired
    private CarDirector carDirector;
    @Autowired
    private CreateCar createCar;

	@Test
	public void testSimpleMail() {
        Car car = carDirector.direct(createCar);
        System.out.println(car.getColor());
	}

}
