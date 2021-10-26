package com.max.javaplus.keyword.static_demo.chapter02;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Father
 * @date 2021/10/26 16:11
 * @desc
 **/
public class Father {
    private int i = test();

    private static int j = method();

    static {
        System.out.println(1);
    }

    public Father() {
        System.out.println(2);
    }

    {
        System.out.println(3);
    }

    private int test() {
        System.out.println(4);
        return 1;
    }

    private static int method() {
        System.out.println(5);
        return 1;
    }

}
