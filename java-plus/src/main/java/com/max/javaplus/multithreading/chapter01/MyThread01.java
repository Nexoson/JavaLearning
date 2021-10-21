package com.max.javaplus.multithreading.chapter01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className ThreadCreate01
 * @date 2021/10/21 15:06
 * @desc 继承 Thread 类
 **/
public class MyThread01 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread :" + Thread.currentThread().getName() + " is running!!!");
    }

    public static void main(String[] args) {
        System.out.println("Thread :" + Thread.currentThread().getName() + " is running!!!");
        MyThread01 my = new MyThread01();
        my.start();
    }


}
