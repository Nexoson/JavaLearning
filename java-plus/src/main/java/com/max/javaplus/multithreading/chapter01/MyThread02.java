package com.max.javaplus.multithreading.chapter01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyThread02
 * @date 2021/10/21 15:11
 * @desc 实现 Runnable 接口
 **/
public class MyThread02 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread :" + Thread.currentThread().getName() + " is running!!!");
    }

    public static void main(String[] args) {
        System.out.println("Thread :" + Thread.currentThread().getName() + " is running!!!");
        MyThread02 my = new MyThread02();
        my.run();
    }

}
