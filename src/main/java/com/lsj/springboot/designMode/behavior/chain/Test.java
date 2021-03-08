package com.lsj.springboot.designMode.behavior.chain;

/**
 * Created by 10326 on 2019/8/26.
 */
public class Test {

    public static void main(String[] args){
        AbstractTarget abstractTarget1 = new DefiniteTarget();
        abstractTarget1.setName("第一个节点");
        AbstractTarget abstractTarget2 = new DefiniteTarget();
        abstractTarget2.setName("第二个节点");
        abstractTarget1.setNetTarget(abstractTarget2);
        abstractTarget1.operate();
    }
}
