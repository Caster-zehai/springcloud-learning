package com.caster.multithreading.multithreadinglearning.controller;

import com.caster.multithreading.multithreadinglearning.service.MyThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/threads")
public class MyThreadsController {

    @Autowired
    public MyThreadService myThreadService;

    @GetMapping("/useThread")
    public void useThread(){
        myThreadService.useThread();
    }

    @GetMapping("/useRunnable")
    public void useRunnable(){
        myThreadService.useRunnable();
    }

    @GetMapping("useJoin")
    public void useJoin(){
        myThreadService.useJoin();
    }

    @GetMapping("useWait")
    public void useWait(){
        try {
            myThreadService.useWait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
