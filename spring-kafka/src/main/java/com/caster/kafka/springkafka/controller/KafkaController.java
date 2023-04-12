package com.caster.kafka.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Value ("${spring.kafka.topics.TEST_TOPIC}")
    private String kafkaTopic;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/send")
    public String send(@RequestParam("msg") String msg){
        kafkaTemplate.send(kafkaTopic,"key",msg);
        return String.format("消息%s发送成功",msg);
    }
}
