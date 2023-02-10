package com.caster.springcloud.apigateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${caster.gateway}")
    private String configInfo;
    @Value("${caster.public}")
    private String publicstr;

    @GetMapping("/configInfo")
    public Object getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/publicstr")
    public Object publicstr() {
        return publicstr;
    }

}

