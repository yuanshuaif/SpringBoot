package com.lsj.springboot.rabbitMQ.springRabbitMQ.consumer;

import com.lsj.springboot.rabbitMQ.springRabbitMQ.config.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/3/14.
 */
@Component
@RabbitListener(queues = FanoutRabbitConfig.QUEUE2_NAME)
public class FanoutConsumer {

    @RabbitHandler
    public void consume(String content) {
        System.out.println("Receiver  : " + content);
    }
}
