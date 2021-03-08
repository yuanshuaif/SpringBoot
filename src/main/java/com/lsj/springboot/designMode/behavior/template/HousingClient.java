package com.lsj.springboot.designMode.behavior.template;

/**
 * Created by 10326 on 2019/9/15.
 */
public class HousingClient {

    public static void main(String[] args){
        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();// 使用模板方法
    }

}
