package com.max.javaplus.keyword.final_demo.chapter01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className FinalTest
 * @date 2021/5/6 16:49
 * @desc 关于final参数的问题
 **/
public class FinalTest {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer);
    }

    static class MyClass {
        // 用final修饰 依然可以拼接字符串
        void changeValue(final StringBuffer buffer) {
            buffer.append(" world");
        }
    }

}

