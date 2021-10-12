package com.max.javaplus.keyword.static_demo.chapter02;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className S
 * @date 2021/10/12 15:14
 * @desc S类 测试加static初始化顺序
 **/
public class S extends F {
    private static String code = "007";
    private int score;

    static {
        System.out.println(S.code);
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类普通语句块");
    }

    public S() {
        System.out.println("执行子类无参构造方法");
    }

    public S(int a, int score) {
        super(a);
        this.score = score;
    }
}
