package com.max.javaplus.devLab.generic.chapter01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className GenericTest02
 * @date 2021/6/7 16:00
 * @desc 泛型学习 ? 进阶使用
 **/
public class GenericTest02 {
    public static void main(String[] args) {
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);

//        getUpperNumberData(name); // 1 String 不是Number的子类
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    public static void getUpperNumberData(Box<? extends Number> data) {
        System.out.println("data :" + data.getData());
    }

}
