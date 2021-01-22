package com.lsj.springboot.rabbitMQ.rabbitMQ.noExchange;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 无交换机的消息队列
 * Created by Administrator on 2019/2/21.
 */
public class ProducerMQ {
    private static final String QUEUE_NAME = "lsj_mq_name";
    private static final String ROUTE_KEY = "lsj_mq_name";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 3.从TCP连接里得到通信管道
        Channel channel = connection.createChannel(1);
        // 4.指定队列
        /*
          * 声明（创建）队列
          * 参数1：队列名称
          * 参数2：为true时server重启队列不会消失
          * 参数3：队列是否是独占的，如果为true只能被一个connection使用，其他连接建立时会抛出异常
          * 参数4：队列不再使用时是否自动删除（没有连接，并且没有未处理的消息)
          * 参数5：建立队列时的其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 5.消息
        String Message = "Hello World";
        // 6.往队列里发送消息
        // RabbitMQ内置了一个空字符串做为默认交换机，通过Routing key将消息路由到队列名与Routing key完全相同的队列中
        channel.basicPublish("", ROUTE_KEY, null, Message.getBytes("UTF-8"));
        System.out.println("发送成功");
        // 7.关闭管道
        channel.close();
        connection.close();

    }
}
