package com.caster.springcloud.nacosrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
    @Bean
    public Queue rabbitmqDemoDirectQueue(){
        return new Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC,true,false,false);
    }
    @Bean
    public DirectExchange rabbitmqDemoDirectExchange() {
        //Direct交换机
        return new DirectExchange(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, true, false);
    }
    @Bean
    public Binding bindDirect() {
        //链式写法，绑定交换机和队列，并设置匹配键
        return BindingBuilder
                //绑定队列
                .bind(rabbitmqDemoDirectQueue())
                //到交换机
                .to(rabbitmqDemoDirectExchange())
                //并设置匹配键
                .with(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING);
    }
}
