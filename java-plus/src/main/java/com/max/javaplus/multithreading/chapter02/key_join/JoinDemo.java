package com.max.javaplus.multithreading.chapter02.key_join;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className JoinDemo
 * @date 2021/10/25 16:47
 * @desc thread.join()  参考: https://www.jianshu.com/p/fc51be7e5bc0
 **/
public class JoinDemo extends Thread {
    // thread.join() 就是指定线程插队,等其执行完,再执行其它线程

    int i;
    // 上一个线程
    Thread previousThread;

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            // 调用上一个线程的join方法,大家自己演示的时候可以把这行代码注释掉
            System.out.println("上一个线程: " + previousThread.getName());
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程: " + Thread.currentThread().getName() + "  num: " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }
}
