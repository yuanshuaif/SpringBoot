package com.lsj.springboot.rabbitMQ.rabbitMQ.workQueue;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by 10326 on 2019/7/14.
 */
public class Consumer1 {

    private final static String QUEUE_NAME = "lsj_mq_name";

    public static void main(String[] args) throws IOException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);//能者多劳模式

        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //自4.0+ 版本后无法再使用QueueingConsumer，而官方推荐使用DefaultConsumer
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
//                super.handleDelivery(consumerTag, envelope, properties, body);
                String message = new String(body,"UTF-8");
                System.out.println(message);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
