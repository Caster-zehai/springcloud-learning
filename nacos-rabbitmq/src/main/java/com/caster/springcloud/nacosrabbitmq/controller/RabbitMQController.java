package com.caster.springcloud.nacosrabbitmq.controller;

import com.caster.springcloud.nacosrabbitmq.service.RabbitMQService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/topic")
public class RabbitMQController {

    @Resource
    private RabbitMQService rabbitMQService;

    @PostMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "msg")String msg) throws Exception{
        return rabbitMQService.sendMsg(msg);
    }
}
