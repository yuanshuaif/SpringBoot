package com.lsj.springboot.designMode.structural.decorate.decorateSimple;

/**
 * Created by 10326 on 2019/4/21.
 * 面包类
 */
public class Bread extends Food {

    private Food basic_food;

    public Bread(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make() + "+面包";
    }
}
