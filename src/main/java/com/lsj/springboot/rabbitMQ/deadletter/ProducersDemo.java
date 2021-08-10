package com.lsj.springboot.rabbitMQ.deadletter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 10326 on 2021/7/3.
 */
@Component
@Slf4j
public class ProducersDemo {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send( ) throws Exception {

        log.info("【订单生成时间】" + new Date().toString() +"【1分钟后检查订单是否已经支付】"  );

        this.rabbitTemplate.convertAndSend("deom5Exchange", "keyDemo5", "订单实体类对象信息", message -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(1 * 1000 * 60 + "");
            return message;
        });

    }

}