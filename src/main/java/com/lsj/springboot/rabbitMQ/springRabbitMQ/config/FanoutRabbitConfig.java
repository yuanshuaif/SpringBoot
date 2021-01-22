package com.lsj.springboot.rabbitMQ.springRabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/3/13.
 */
@Configuration
public class FanoutRabbitConfig {

    public final static String QUEUE1_NAME = "queue1";
    public final static String QUEUE2_NAME = "queue2";
    public final static String EXCHANGE_NAME = "fanoutExchange";

    @Bean
    public Queue fanoutQueueMessage() {
        return new Queue(QUEUE1_NAME);
    }

    @Bean
    public Queue fanoutQueueMessages() {
        return new Queue(QUEUE2_NAME);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }
    /**
     * FanoutExchange（广播模式、路由不起作用，所有队列得到的消息是一样的）
     * @param fanoutQueueMessage
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding fanoutBindingExchangeMessage(Queue fanoutQueueMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueMessage).to(fanoutExchange);
    }

    @Bean
    Binding fanoutBindingExchangeMessages(Queue fanoutQueueMessages, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueMessages).to(fanoutExchange);
    }

}
