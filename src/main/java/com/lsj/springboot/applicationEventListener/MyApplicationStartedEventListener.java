package com.lsj.springboot.applicationEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import javax.servlet.annotation.WebListener;

/**
 * Created by 10326 on 2019/4/5.
 * 1.实现ApplicationListener接口
 */
@WebListener
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SpringApplication app = event.getSpringApplication();
      /*  app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
                printStream.println("SPRINGBOOT:LSJ");
            }
        });// 不显示banner信息*/
        LOGGER.info("==MyApplicationStartedEventListener==");
    }
}
