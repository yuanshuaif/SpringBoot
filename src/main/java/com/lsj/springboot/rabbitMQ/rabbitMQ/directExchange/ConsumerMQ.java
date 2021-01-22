package com.lsj.springboot.rabbitMQ.rabbitMQ.directExchange;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2019/2/21.
 */
public class ConsumerMQ {
    private static final String EXCHANGE_NAME = "lsj_mq_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 3.从TCP连接里得到通信管道
        Channel channel = connection.createChannel(1);
        /**
         * 4.绑定交换机(队列名未知)
         */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false);
        // 4.1.随机获取队列——产生一个随机的队列名称
        String queueNameA = channel.queueDeclare().getQueue();
        System.out.println(queueNameA);
        // 4.2.对队列进行绑定
        channel.queueBind(queueNameA, EXCHANGE_NAME, "A");
      /*  String queueNameB = channel.queueDeclare().getQueue();
        System.out.println(queueNameB);
        channel.queueBind(queueNameB, EXCHANGE_NAME, "B");*/
        // 5.创建消费者实例，并与管道关联
        Consumer consumer = new DefaultConsumer(channel){
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
        };
        channel.basicConsume(queueNameA, true, consumer);
    }
}
