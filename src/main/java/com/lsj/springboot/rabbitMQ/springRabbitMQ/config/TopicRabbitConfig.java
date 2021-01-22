package com.lsj.springboot.rabbitMQ.springRabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/3/13.
 */
@Configuration
public class TopicRabbitConfig {
    public final static String QUEUE1_NAME = "queue1";
    public final static String QUEUE2_NAME = "queue2";
    public final static String EXCHANGE_NAME = "exchange";

    @Bean
    public Queue queueMessage() {
        return new Queue(QUEUE1_NAME);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(QUEUE2_NAME);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * queueMessage为Bean的id
     * topic.message的消息发到queueMessages队列中
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     * topic.开头的消息都可以发到queueMessages队列中
     * @param queueMessages
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
