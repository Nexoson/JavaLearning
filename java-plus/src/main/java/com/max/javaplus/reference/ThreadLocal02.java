package com.max.javaplus.reference;

import java.util.concurrent.TimeUnit;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className ThreadLocal01
 * @date 2021/10/26 21:04
 * @desc ThreadLocal学习, 其本质就是一个容器， 每个ThreadLocal都有对应的一个Thread和各自的ThreadLocalMap
 **/
public class ThreadLocal02 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }


    static class Person {
        String name = "张三";
    }
}
