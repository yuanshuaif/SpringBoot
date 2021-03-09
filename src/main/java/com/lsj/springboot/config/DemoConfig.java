package com.lsj.springboot.config;

import com.lsj.springboot.entity.Demo;
import com.lsj.springboot.entity.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Demo.class)
// 使用指定的配置文件，留给开发者使用的：application.properties或者application.yml
//
@ConditionalOnProperty(prefix = "spring.application", name = "name", havingValue = "fibz-bx")
public class DemoConfig {

    @Autowired
    private Demo demo;

     @Bean(name = "demoService")
     public DemoService demoService(){
         return new DemoService(demo.getName(), demo.getAge());
     }
}
