package com.caster.kafka.springkafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.topics.TEST_TOPIC}",groupId = "Group1")
    public void listenGroup1(ConsumerRecord<String, String> record, Acknowledgment ack){
        String value = record.value();
        System.out.println("Group1 message: " + value);
        System.out.println("Group1 record: " + record);
        //手动提交offset，一般是提交一个banch，幂等性防止重复消息
        ack.acknowledge();
    }
}
