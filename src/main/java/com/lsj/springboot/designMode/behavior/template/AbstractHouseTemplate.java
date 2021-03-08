package com.lsj.springboot.designMode.behavior.template;

/**
 * Created by 10326 on 2019/9/15.
 * buildHouse()是模板方法并定义了在建造房子过程中一系列方法的执行顺序。
 */
public abstract class AbstractHouseTemplate implements HouseTemplate{
    @Override
    public final void buildHouse() {
        buildFoundation();//
        buildPillars();
        buildWalls();
        buildWindows();//
        System.out.println("House is built.");
    }

    private void buildWindows() {
        System.out.println("Building Glass Windows");
    }

    private void buildFoundation() {
        System.out.println("Building foundation with cement,iron rods and sand");
    }
}
