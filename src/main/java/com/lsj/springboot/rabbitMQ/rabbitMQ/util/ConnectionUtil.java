package com.lsj.springboot.rabbitMQ.rabbitMQ.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 10326 on 2019/7/14.
 */
public class ConnectionUtil {

    public static Connection getConnection(){
        // 1.ConnectionFactory连接到RabbitMQ服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672); // 默认端口
        factory.setUsername("yuanshuaif");
        factory.setPassword("Aa123456");
        // 2.获得connection(TCP连接)
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
