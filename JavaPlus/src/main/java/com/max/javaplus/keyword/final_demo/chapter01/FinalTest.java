package com.max.javaplus.keyword.final_demo.chapter01;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

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
        //通过jol工具包打印对象的地址
        System.out.println(ClassLayout.parseInstance(buffer).toPrintable());

        myClass.changeValue2(buffer);
        System.out.println(buffer);
    }

    static class MyClass {

        void changeValue(final StringBuffer buffer) {
            buffer.append(" world");
        }

        void changeValue2(StringBuffer buffer) {
            System.out.println(ClassLayout.parseInstance(buffer).toPrintable());
            buffer = new StringBuffer("abc");
            System.out.println(ClassLayout.parseInstance(buffer).toPrintable());
        }
    }

    @Test
    public void test() {
        String s1 = "aaa";
        System.out.println(s1);
        change(s1);
        System.out.println(s1);
        StringBuffer s2 = new StringBuffer();
        s2.append("kkk");
        System.out.println(s2);
        change(s2);
        System.out.println(s2);
    }

    public static void change(StringBuffer s) {
        s.append("zzz");
    }

    public static void change(String s) {
        s += "bbb";
    }
}

