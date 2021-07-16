package com.max.javaplus.keyword.string_demo.chapter02;

import org.junit.Test;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className StringTest
 * @date 2021/7/5 10:57
 * @desc 玩转String
 **/
public class StringTest {

    @Test
    public void test01() {

        String str2 = new String("str")+new String("01");
        String str1 = "str01";
        String str3 = str2.intern();
        Object obj = new Object();
        Integer.valueOf("12");
/*        System.out.println("str1: " + GraphLayout.parseInstance(str1).toPrintable());
        System.out.println("str2: " + GraphLayout.parseInstance(str2).toPrintable())*/;
        System.out.println(str3==str2);

    }
}
