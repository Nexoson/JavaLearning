package com.max.javaplus.keyword.static_demo.chapter02;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className F
 * @date 2021/10/12 15:07
 * @desc F类 测试初始化顺序
 **/
public class F {
    private static String name = "F";

    private int a;

    static {
        System.out.println(F.name);
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类普通语句块");
    }

    public F() {
        System.out.println("执行父类无参构造方法");
    }

    public F(int a) {
        this.a = a;
    }
}
