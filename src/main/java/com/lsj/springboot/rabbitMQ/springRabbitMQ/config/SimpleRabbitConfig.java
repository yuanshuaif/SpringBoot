package com.lsj.springboot.rabbitMQ.springRabbitMQ.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/3/13.
 */
@Configuration
public class SimpleRabbitConfig {

    public final static String QUEUE_NAME = "lsj";

    @Bean
    public Queue getQueue(){
        return new Queue(QUEUE_NAME);
    }
}
