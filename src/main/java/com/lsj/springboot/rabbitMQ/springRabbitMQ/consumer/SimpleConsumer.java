package com.lsj.springboot.rabbitMQ.springRabbitMQ.consumer;

import com.lsj.springboot.rabbitMQ.springRabbitMQ.config.SimpleRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/3/13.
 */
@Component
@RabbitListener(queues = SimpleRabbitConfig.QUEUE_NAME)
public class SimpleConsumer {

    @RabbitHandler
    public void consume(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
