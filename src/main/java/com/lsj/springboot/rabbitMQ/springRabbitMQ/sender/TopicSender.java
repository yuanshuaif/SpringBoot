package com.lsj.springboot.rabbitMQ.springRabbitMQ.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/3/14.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
//        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        this.amqpTemplate.convertAndSend("exchange", "topic1.messages", context);
    }
}
