package com.lsj.springboot.designMode.creational.build.Impl;

import com.lsj.springboot.designMode.creational.build.Entity.Car;
import com.lsj.springboot.designMode.creational.build.Service.CreateCar;
import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/7/28.
 */
@Service
public class CreateCarImpl implements CreateCar {
    @Override
    public void selectColor() {
        car.setColor("颜色");
    }

    @Override
    public void selectCarDoor() {
        car.setCarDoor(2);
    }

    @Override
    public void selectTires() {
        car.setTires(4);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
