package com.lsj.springboot.designMode.behavior.chain.second;

/**
 * Created by 10326 on 2019/8/26.
 * 控制台处理器.
 */
public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger :"+message);
    }
}
