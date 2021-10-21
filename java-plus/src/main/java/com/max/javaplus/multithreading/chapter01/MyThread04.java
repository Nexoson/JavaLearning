package com.max.javaplus.multithreading.chapter01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyThread04
 * @date 2021/10/21 16:05
 * @desc 基于线程池的方式
 **/
public class MyThread04 {
    /**
     * 线程和数据库连接这些资源都是非常宝贵的资源。那么每次需要的时候创建，不需要的时候销
     * 毁，是非常浪费资源的。那么我们就可以使用缓存的策略，也就是使用线程池。
     **/
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(true){
            threadPool.execute(new Runnable() {
                // 提交多个线程,并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
