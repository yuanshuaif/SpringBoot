package com.lsj.springboot.designMode.behavior.chain.second;

/**
 * Created by 10326 on 2019/8/26.
 * error日志处理器.
 */
public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger :"+message);
    }
}
