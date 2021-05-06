package com.max.javaplus.keyword.static_demo.chapter01;

import org.junit.Test;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className compare2final
 * @date 2021/5/6 16:32
 * @desc
 **/
public class Compare2final {

    /**
     * 很多时候会容易把static和final关键字混淆，
     * static作用于成员变量用来表示只保存一份副本，
     * 而final的作用是用来保证变量不可变。看下面这个例子
     **/
    @Test
    public void test01() {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }

    static class MyClass {
        public final double i = Math.random();
        public static double j = Math.random();
    }
}
