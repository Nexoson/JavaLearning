package com.max.javaplus.keyword.static_demo.chapter02;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Son
 * @date 2021/10/26 16:13
 * @desc
 **/
public class Son extends Father {

    private int i = test();

    private static int j = method();

    static {
        System.out.println(6);
    }

    public Son() {
        System.out.println(7);
    }

    {
        System.out.println(8);
    }

    public int test() {
        System.out.println(9);
        return 1;
    }

    public static int method() {
        System.out.println(10);
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("====================");
        Son s2 = new Son();

        // 5, 1, 10, 6, 4, 3, 2, 9, 8, 7
        // ====
        // 4, 3, 2, 9, 8, 7

    }
}
