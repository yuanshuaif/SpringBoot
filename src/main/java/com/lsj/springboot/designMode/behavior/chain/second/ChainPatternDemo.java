package com.lsj.springboot.designMode.behavior.chain.second;

/**
 * Created by 10326 on 2019/8/26.
 */
public class ChainPatternDemo {
    public static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return  errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger logger = getChainOfLoggers();
        logger.logMessage(1,"一级日志记录");
        System.out.println("--------------------------------");
        logger.logMessage(2,"二级日志记录");
        System.out.println("--------------------------------");
        logger.logMessage(3,"三级日志记录");
    }
}
