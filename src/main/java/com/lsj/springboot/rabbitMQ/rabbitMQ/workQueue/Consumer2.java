package com.lsj.springboot.rabbitMQ.rabbitMQ.workQueue;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by 10326 on 2019/7/14.
 */
public class Consumer2 {

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
                try {
                    String message = new String(body,"UTF-8");
                    System.out.println(message);
                    Thread.sleep(10);
                    /*消息应答：2.手动确认*/
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 第3个参数requeue： true ：重回队列，false ：丢弃，我们在nack方法中必须设置 false，否则重发没有意义。
                    channel.basicNack(envelope.getDeliveryTag(), false, false);
                    //requeue ： true ：重回队列，false ：丢弃
//                    channel.basicReject(envelope.getDeliveryTag(), false);
                }finally {

                }
            }
        };
        /*消息应答：1.第二个参数未关闭自动确认，开启手动确认*/
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
