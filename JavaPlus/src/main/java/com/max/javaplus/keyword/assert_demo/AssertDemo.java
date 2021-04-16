package com.max.javaplus.keyword.assert_demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className AssertDemo
 * @date 2021/4/15 19:06
 * @desc
 **/
@Slf4j
public class AssertDemo {

    public static void main(String[] args) {
        test1(-5);
        test1(5);
        System.out.println();
        test2(-3);
    }

    private static void test1(int a) {
        assert a > 0;
        System.out.println(a);
    }

    private static void test2(int a) {
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
}
