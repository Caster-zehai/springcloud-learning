package com.caster.multithreading.multithreadinglearning.controller;

import com.caster.multithreading.multithreadinglearning.service.MyExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executor")
public class MyExecutorController {

    @Autowired
    private MyExecutorService myExecutorService;

    @GetMapping("/useThreadPool")
    public void useThreadPoolExecutor(){
        myExecutorService.useThreadPoolExecutor();
    }

}
