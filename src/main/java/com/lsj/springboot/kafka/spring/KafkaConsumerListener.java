package com.lsj.springboot.kafka.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by 10326 on 2021/4/17.
 */
public class KafkaConsumerListener implements MessageListener<String, String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> record){
        System.out.printf("partition = %d,offset = %d, key= %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());

    }
}
