package com.caster.springcloud.nacosrabbitmq.consumer;

import com.caster.springcloud.nacosrabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = {RabbitMQConfig.RABBITMQ_DEMO_TOPIC})
public class RabbitConsumer {
    @RabbitHandler
    public void process(Map map){
        System.out.println("消费者RabbitConsumer从RabbitMQ服务端消费消息："+map.toString());
    }
}