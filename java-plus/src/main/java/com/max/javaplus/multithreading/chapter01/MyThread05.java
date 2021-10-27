package com.max.javaplus.multithreading.chapter01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyThread05
 * @date 2021/10/27 9:27
 * @desc 有返回值的线程
 **/
public class MyThread05 {

    public static void main(String[] args) throws Exception {

        System.out.println(2);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        System.out.println(3);
        new Thread(futureTask).start();
        System.out.println(4);
        int result = futureTask.get();
        System.out.println(5);
        System.out.println(result);
        System.out.println(6);
    }


    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return 1;
        }
    }
}
