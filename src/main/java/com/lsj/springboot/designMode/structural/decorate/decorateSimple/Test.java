package com.lsj.springboot.designMode.structural.decorate.decorateSimple;

/**
 * Created by 10326 on 2019/4/21.
 * 设计模式——装饰者模式;典型应用IO流
 *
 * 1.继承同一个父类；2.构造方法中传入父类型的参数；3.重写的make方法中加入自己的逻辑
 */
public class Test {

    public static void main(String args[]){

        Food food = new Cream(new Bread(new Food("食物")));
        System.out.println(food.make());

        Food food1 = new Bread(new Cream(new Food("食物")));
        System.out.println(food1.make());

       /* // IO流  Writer作为顶层接口；FileWriter 作为被装饰类；BufferedWriter、PrintWriter作为装饰类
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("qweqw")));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
