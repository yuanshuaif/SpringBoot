package com.lsj.springboot.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10326 on 2021/4/17.
 */
public class ConsumerSimple {

    public static void main(String[] args){
        Map<String, Object> props = new HashMap<>();
        // bootstrap.servers 表示kafka集群  如果有多个用“，”隔开
        props.put("bootstrap.servers", "localhost:9092");
        // 消费者的分组id
        props.put("group.id", "testGroup1");
        // 消费者是否自动提交
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.iterval.ms", "1000");
        // 序列化、反序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        String topic = "test-topic";
        Consumer<String, String> consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList(topic));
        while (true){
            ConsumerRecords<String, String> records = consumer.poll(100);
            for(ConsumerRecord<String, String> record : records){
                System.out.printf("partition = %d,offset = %d, key= %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
            }
        }
    }
}
