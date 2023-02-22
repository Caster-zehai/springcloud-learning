package com.caster.multithreading.multithreadinglearning.service.impl;

import com.caster.multithreading.multithreadinglearning.service.MyExecutorService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class MyExecutorServiceImpl implements MyExecutorService {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    @Override
    public void useThreadPoolExecutor() {

        /**
         * corePoolSize: 核心线程数为 5。
         * maximumPoolSize ：最大线程数 10
         * keepAliveTime : 等待时间为 1L。
         * unit: 等待时间的单位为 TimeUnit.SECONDS。
         * workQueue：任务队列为 ArrayBlockingQueue，并且容量为 100;
         * handler:饱和策略为 CallerRunsPolicy。
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i = 0;i < 10;i++){
            Runnable worker = new MyRunnable(""+i);
            threadPoolExecutor.execute(worker);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    class MyRunnable implements Runnable{
        private String command;

        public MyRunnable(String s) {
            this.command = s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
        }

        private void processCommand() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return this.command;
        }
    }

}
