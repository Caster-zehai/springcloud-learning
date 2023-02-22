package com.caster.springcloud.nacosrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRabbitmqApplication.class, args);
    }

}
