package com.lsj.springboot.rabbitMQ.rabbitMQ.noExchange;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2019/2/21.
 */
public class ConsumerMQ {

    private static final String QUEUE_NAME = "lsj_mq_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 3.从TCP连接里得到通信管道
        Channel channel = connection.createChannel(1);
        // 4.连接队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 5.创建消费者实例，并与管道关联
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException
            {
                // no work to do
                String message = new String(body, "UTF-8");
                System.out.println(message);
            }
        });
    }
}
