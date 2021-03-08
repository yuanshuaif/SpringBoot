package com.lsj.springboot.designMode.creational.build.Entity;

/**
 * Created by 10326 on 2019/7/28.
 */
public class Car {
    private String color;
    private int carDoor;
    private int tires;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getCarDoor() {
        return carDoor;
    }
    public void setCarDoor(int carDoor) {
        this.carDoor = carDoor;
    }
    public int getTires() {
        return tires;
    }
    public void setTires(int tires) {
        this.tires = tires;
    }

}
