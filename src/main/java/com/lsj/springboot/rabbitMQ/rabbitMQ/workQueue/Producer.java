package com.lsj.springboot.rabbitMQ.rabbitMQ.workQueue;

import com.lsj.springboot.rabbitMQ.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


/**
 * Created by 10326 on 2019/7/14.
 */
public class Producer {

    private final static String QUEUE_NAME = "lsj_mq_name";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        // #####  开启信道的发布确认模式（同步）
        channel.confirmSelect();

        for (int i = 0; i < 50; i++) {
            String message = "nihao" + i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
//            Thread.sleep(100 * i);
        }

        if (channel.waitForConfirms()){
           System.out.println("send is success");
        }else{
            System.out.println("send is failed");
        }

        channel.close();
        connection.close();
    }
}
