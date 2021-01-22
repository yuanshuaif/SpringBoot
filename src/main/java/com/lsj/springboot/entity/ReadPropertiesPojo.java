package com.lsj.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/2/24.
 * properties文件的使用
 */
@Component("readProperties")
@PropertySource("classpath:/config/cs.properties")
@ConfigurationProperties(prefix = "springboot.properties")
public class ReadPropertiesPojo {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReadPropertiesPojo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
