package com.lsj.springboot.designMode.structural.decorate.decorateSimple;

/**
 * Created by 10326 on 2019/4/21.
 */
public class Food {

    private String food_name;

    public Food() {
    }

    public Food(String food_name) {
        this.food_name = food_name;
    }

    public String make() {
        return food_name;
    };
}
