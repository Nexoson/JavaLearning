package com.max.javaplus.multithreading.chapter01;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyThread03
 * @date 2021/10/21 15:34
 * @desc ExecutorService、Callable<Class>、Future 有返回值线程
 **/
public class MyThread03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 8;
        // 创建一个线程池(线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 )
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        ArrayList<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " ");
            // 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }

    }

    private static class MyCallable implements Callable {
        public  String name;
        public MyCallable(String s) {
            this.name = s;
        }

        @Override
        public Object call() {
            return name;
        }
    }
}
