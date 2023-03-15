package com.caster.springcloud.kafkatest.controller;

import cn.hutool.core.util.RandomUtil;
import com.caster.springcloud.kafkatest.config.ProducersConfig;
import com.caster.springcloud.kafkatest.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private StreamBridge streamBridge;

    @Autowired
    private ProducersConfig producersConfig;

    @PostMapping("/log")
    public boolean log(@RequestBody Person person){
        return producersConfig.log(person);
    }

    @PostMapping("/addAge")
    public boolean addAge(@RequestBody Person person){
        person.setAge(RandomUtil.randomInt(10, 90));
        person.setSuccess(RandomUtil.randomBoolean());
        person.setBirthday(new Date());

        // 通过streamBridge直接对应的topic发送消息
        return streamBridge.send("addAge", person);
    }

}