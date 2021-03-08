package com.lsj.springboot.designMode.behavior.visitor;

/**
 * Created by 10326 on 2020/5/4.
 */
public class CEOVisitor implements Visitor {
    @Override
    public void visit(ProjectElement element) {
        System.out.println("CEO业务处理");
        // 回调 （可以没有）
        element.sigature("CEO");
    }
}
