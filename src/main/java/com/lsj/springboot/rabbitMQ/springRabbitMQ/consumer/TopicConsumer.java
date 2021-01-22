package com.lsj.springboot.rabbitMQ.springRabbitMQ.consumer;

import com.lsj.springboot.rabbitMQ.springRabbitMQ.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/3/14.
 */
@Component
@RabbitListener(queues = TopicRabbitConfig.QUEUE1_NAME)
public class TopicConsumer {

    @RabbitHandler
    public void consume(String content) {
        System.out.println("Receiver  : " + content);
    }
}
