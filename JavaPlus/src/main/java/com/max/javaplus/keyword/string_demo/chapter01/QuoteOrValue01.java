package com.max.javaplus.keyword.string_demo.chapter01;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className QuoteOrValue01
 * @date 2021/5/7 14:34
 * @desc Java 值传递 探秘
 **/
public class QuoteOrValue01 {

    public static void main(String[] args) {
        String a = new String("a");
        System.out.println("对象: " + GraphLayout.parseInstance(a).toPrintable());
        System.out.println("对象: " + GraphLayout.parseInstance("a").toPrintable());
        a = "b";
        System.out.println("对象: " + GraphLayout.parseInstance(a).toPrintable());
        System.out.println("对象: " + GraphLayout.parseInstance("b").toPrintable());
        //changeValue(a);
        System.out.println(a);
    }

    public static void changeValue(String temp) {
        String a = new String("a");
        System.out.println("对象: " + ClassLayout.parseInstance(a).toPrintable());
        System.out.println("对象: " + GraphLayout.parseInstance("a").toPrintable());
        a += "a";


    }
}
