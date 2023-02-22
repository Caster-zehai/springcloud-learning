package com.caster.multithreading.multithreadinglearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MultithreadingLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultithreadingLearningApplication.class, args);
    }

}
