package com.caster.multithreading.multithreadinglearning.service.impl;

import com.caster.multithreading.multithreadinglearning.service.MyThreadService;
import org.springframework.stereotype.Service;

@Service
public class MyThreadServiceImpl implements MyThreadService {

    @Override
    public void useThread() {
        Thread1 th1 = new Thread1("A");
        Thread1 th2 = new Thread1("B");
        th1.start();
        th2.start();
        System.out.println("main");
        //start()方法的调用后并不是立即执行多线程代码，而是使得该线程变为可运行态（Runnable），什么时候运行是由操作系统决定的
    }

    @Override
    public void useRunnable() {
        new Thread(new Runnable2("C")).start();
        new Thread(new Runnable2("D")).start();
        System.out.println("main");
    }

    @Override
    public void useJoin() {
        System.out.println(Thread.currentThread().getName()+"主线程开始");
        Thread1 th1 = new Thread1("A");
        Thread1 th2 = new Thread1("B");
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"主线程结束");
    }

    @Override
    public void useWait() throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Runnable3 pa = new Runnable3("A", c, a);
        Runnable3 pb = new Runnable3("B", a, b);
        Runnable3 pc = new Runnable3("C", b, c);
        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }

    //runnable中使用wait(),notify(),synchronized
    class Runnable3 implements Runnable{

        private String strname;
        private Object prev;
        private Object self;

        public Runnable3(String strname, Object prev, Object self) {
            this.strname = strname;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0){
                synchronized (prev){
                    synchronized (self){
                        System.out.println(strname+"消费1");
                        count--;
                        self.notify();
                    }
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    //使用Thread创建线程
    class Thread1 extends Thread{
        public String strname;
        public Thread1(String strname){
            this.strname = strname;
        }
        @Override
        public void run() {
            for (int i=0;i<5;i++){
                System.out.println(strname+"线程输出:"+i);
                try {
                    sleep((int)Math.random()*10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //使用Runnable创建线程
    class Runnable2 implements Runnable{
        public String strname;
        public Runnable2(String strname){
            this.strname = strname;
        }
        @Override
        public void run() {
            for (int i=0;i<5;i++){
                System.out.println(strname+"线程输出:"+i);
                try {
                    Thread.sleep((int)Math.random()*10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
