package com.lsj.springboot.kafka.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by 10326 on 2021/4/17.
 */
public class SpringProducer {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-beans.xml");
        KafkaTemplate<String, String> kafkaTemplate = (KafkaTemplate)ctx.getBean("kafkaTemplate");
        kafkaTemplate.send("kafka-topic", "message", "我的测试消息1");
        kafkaTemplate.send("kafka-topic", "message", "我的测试消息2");
        kafkaTemplate.send("kafka-topic", "message", "我的测试消息3");
        KafkaConsumerListener consumer = (KafkaConsumerListener)ctx.getBean("consumerListener");
        System.out.printf("");
    }
}
