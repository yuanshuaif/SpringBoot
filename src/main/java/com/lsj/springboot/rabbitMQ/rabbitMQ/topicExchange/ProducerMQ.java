package com.lsj.springboot.rabbitMQ.rabbitMQ.topicExchange;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2019/2/21.
 */
public class ProducerMQ {
    private static final String EXCHANGE_NAME = "ly_mq_exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 3.从TCP连接里得到通信管道
        Channel channel = connection.createChannel(1);
        /**
         * 4.绑定交换机
         * 直连交换机
         */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, false);
        /**
         * 5.将队列绑定到交换机上
         *  在RabbitMQ Management中实现绑定
         */

        // 6.消息
        /*String MessageA = "Hello World A";
        String MessageB = "Hello World B";*/
        // 7.往交换机里发送消息
        channel.basicPublish(EXCHANGE_NAME, "A.C", null,  "A.C".getBytes("UTF-8"));
        channel.basicPublish(EXCHANGE_NAME, "C.C", null,  "C.C".getBytes("UTF-8"));
        channel.basicPublish(EXCHANGE_NAME, "A.B", null,  "A.B".getBytes("UTF-8"));
        channel.basicPublish(EXCHANGE_NAME, "C.B", null,  "C.B".getBytes("UTF-8"));
        System.out.println("发送成功");
        // 8.关闭管道
        channel.close();
        connection.close();
    }
}
