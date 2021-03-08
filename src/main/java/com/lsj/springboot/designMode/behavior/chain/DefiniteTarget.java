package com.lsj.springboot.designMode.behavior.chain;

/**
 * Created by 10326 on 2019/8/26.
 * 具体责任对象
 */
 public class DefiniteTarget extends AbstractTarget {

    @Override
    public void operate() {
        if(netTarget != null){
            netTarget.operate();
            System.out.println(name + "正在操作");
        }else {
           System.out.println(name + "正在操作");
        }
    }
}
