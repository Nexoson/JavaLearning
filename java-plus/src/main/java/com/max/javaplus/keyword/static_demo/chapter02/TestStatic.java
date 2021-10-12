package com.max.javaplus.keyword.static_demo.chapter02;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className TestStatic
 * @date 2021/10/12 15:16
 * @desc 初始化顺序测试
 **/
public class TestStatic {

    public static void main(String[] args) {
        S s = new S();
        /**
         *
         * 父类（静态变量/静态语句块） 谁在前就先执行谁
         * 子类（静态变量/静态语句块）
         * 父类（实例变量、普通语句块）
         * 父类（构造函数）
         * 子类（实例变量、普通语句块）
         * 子类（构造函数）
         **/

    }
}
