package com.caster.springcloud.kafkatest.config;

import com.caster.springcloud.kafkatest.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Configuration
public class ProducersConfig {

    private BlockingQueue<Person> unbounded = new LinkedBlockingQueue<>();

    /**
     * 对应yml中配置的logP-out-0通道，即topic log
     * @return java.util.function.Supplier<com.example.kafka.entity.Person>
     **/
    @Bean
    public Supplier<Person> logP(){
        return () -> unbounded.poll();
    }

    /**
     * 调用本方法向log topic发送消息
     *
     * @param person:
     * @return boolean
     **/
    public boolean log(Person person){
        return unbounded.offer(person);
    }

}