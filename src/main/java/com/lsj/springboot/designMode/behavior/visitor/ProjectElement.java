package com.lsj.springboot.designMode.behavior.visitor;

/**
 * Created by 10326 on 2020/5/4.
 */
public class ProjectElement implements Element{
    private String projectName;
    private String projectContent;
    private String visitorName;

    public ProjectElement(String projectName, String projectContent){
        this.projectName = projectName;
        this.projectContent = projectContent;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void sigature(String visitorName){
        this.visitorName = visitorName;
        System.out.println(visitorName + "访问了");
    }
}
