package com.max.javaplus.devLab.generic.chapter01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className GenericTest01
 * @date 2021/6/7 15:37
 * @desc 泛型学习 ? 基础使用
 **/
public class GenericTest01 {

    public static void main(String[] args) {
        Box<Number> name = new Box<Number>(99);
        Box<Integer> age = new Box<Integer>(720);
        // Box<Number> b = age; // 1 编译错误

        getData(name);
        Box<Float> f = new Box<Float>(3.14f);
        // b.setData(f);        // 2 编译错误
        getData(age);


    }

/*  Box<Number> 适配不了 Box<Integer>
    private static void getData(Box<Number> name) {
    }
*/

    private static void getData(Box<?> name) {
    }

}
