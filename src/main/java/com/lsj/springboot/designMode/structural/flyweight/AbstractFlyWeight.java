package com.lsj.springboot.designMode.structural.flyweight;

/**
 * Created by 10326 on 2019/8/28.
 * 抽象享元类
 */
public abstract class AbstractFlyWeight {

    //1.0
    /*内部状态：不随外部环境而改变，在享元对象间共享*/
    private String intrinsic;

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    //2.0
    /*享元对象必须接受外部状态*/
    //3.0
    /*定义业务方法*/
    public abstract void operate(String extrinsic);

}
