package com.lsj.springboot.designMode.behavior.template;

/**
 * Created by 10326 on 2019/9/15.
 */
public class WoodenHouse extends AbstractHouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}
