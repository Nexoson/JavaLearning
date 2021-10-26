package com.max.javaplus.reference;

import java.util.concurrent.TimeUnit;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className ThreadLocal01
 * @date 2021/10/26 21:04
 * @desc ThreadLocal学习
 **/
public class ThreadLocal01 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }


    static class Person {
        String name = "张三";
    }
}
