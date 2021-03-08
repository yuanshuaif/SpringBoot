package com.lsj.springboot.designMode.behavior.command;

/**
 * Created by 10326 on 2019/10/13.
 * 调用者Invoker
 */
public class XiaoAi {

    private Command command;

    /**
     * 设置具体的命令
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void doCommand() {
        command.execute();
    }

}
