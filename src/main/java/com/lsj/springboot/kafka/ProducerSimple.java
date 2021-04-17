package com.lsj.springboot.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10326 on 2021/4/17.
 */
public class ProducerSimple {

    public static void main(String[] args){
        Map<String, Object> props = new HashMap<>();
        // bootstrap.servers 表示kafka集群  如果有多个用“，”隔开
        props.put("bootstrap.servers", "localhost:9092");
        // 连接zk，获取kafka集群配置信息；
        props.put("zk.connect", "127.0.0.1:2181");
        // 序列化、反序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        String topic = "test-topic";
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        // topic position key value;topic key value;topic value;
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 1"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 2"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 3"));
        producer.close();
    }
}
