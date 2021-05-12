package com.max.javaplus.keyword.string_demo.chapter01;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className QuoteOrValue
 * @date 2021/5/7 14:28
 * @desc Java到底是传值还是传引用
 **/
public class QuoteOrValue02 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        //通过jol工具包打印对象的地址
        System.out.println("" + ClassLayout.parseInstance(buffer).toPrintable());
        System.out.println("对象: " + GraphLayout.parseInstance(buffer).toPrintable());


        myClass.changeValue2(buffer);
        System.out.println(buffer);
        System.out.println("对象: " + GraphLayout.parseInstance(buffer).toPrintable());
    }

    static class MyClass {

        void changeValue(final StringBuffer buffer) {
            buffer.append(" world");
        }

        void changeValue2(StringBuffer buffer) {
            System.out.println("进来了");
            System.out.println("对象: " + GraphLayout.parseInstance(buffer).toPrintable());
            buffer = new StringBuffer("abc");
            System.out.println("对象: " + GraphLayout.parseInstance(buffer).toPrintable());
            System.out.println("出去了");
        }
    }
}
