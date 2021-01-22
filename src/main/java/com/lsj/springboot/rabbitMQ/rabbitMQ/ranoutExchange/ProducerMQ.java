package com.lsj.springboot.rabbitMQ.rabbitMQ.ranoutExchange;

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

    private static final String EXCHANGE_NAME = "ys_mq_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 3.从TCP连接里得到通信管道
        Channel channel = connection.createChannel(1);
        /**
         * 4.绑定交换机
         * 广播模式
         * 交换机会将消息全部发送给绑定到自己身上的队列，忽略Routing key
         */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, false);
        /**
         * 5.将队列绑定到交换机上
         *  在RabbitMQ Management中实现绑定
         */

        // 6.消息
        String Message = "Hello World";
        // 7.往交换机里发送消息
        channel.basicPublish(EXCHANGE_NAME, "", null,  Message.getBytes("UTF-8"));
        System.out.println("发送成功");
        // 8.关闭管道
        channel.close();
        connection.close();
    }
}
