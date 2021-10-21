package com.max.javaplus.multithreading.chapter01;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyThreadPool
 * @date 2021/10/21 16:12
 * @desc 4种线程池(java中线程池的顶级接口是Executor  严格而言，正在的线程池是ExecutorService)
 **/
public class MyThreadPool {
    /**
     * Java 里面线程池的顶级接口是 Executor，但是严格意义上讲 Executor 并不是一个线程池，而
     * 只是一个执行线程的工具。真正的线程池接口是 ExecutorService。
     **/

    @Test
    public void test01(){
        /**
         * 创建一个可根据需要创建新线程的线程池,但是在以前构造的线程可用时将复用它们.
         * 对于执行很多短期异步任务的程序而言,这些线程池通常可以提高程序性能.调用excute
         * 将复用以前构造的线程(如果线程可用).如果现有线程没有可用的,则创建一个新线程并
         * 添加到池中.终止并从缓存中移除那些已有60秒钟未被使用的线程。因此，长时间保持
         * 空闲的线程池不会使用任何资源。
         **/
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

    @Test
    public void test02(){
        /**
         * 创建一个可复用固定线程数的线程池,以共享的无界队列方式来运行这些线程.
         **/
        ExecutorService executorService = Executors.newFixedThreadPool(20);
    }

    @Test
    public void test03(){
        /**
         * 创建一个线程池,它可安排在给定延迟后运行命令定期地执行
         **/
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);
        scheduledPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒");
            }
        },3, TimeUnit.SECONDS);

        scheduledPool.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟 1 秒后每三秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }

    @Test
    public void test04(){
        /**
         *  1.返回一个线程池，只有一个线程  2.可以在旧的线程挂掉之后，重新启动一个新的线程来替代它。  达到起死回生的效果。
         **/
        ExecutorService executorPool = Executors.newSingleThreadExecutor();
    }
}
