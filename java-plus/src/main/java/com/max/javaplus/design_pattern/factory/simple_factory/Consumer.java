package com.max.javaplus.design_pattern.factory.simple_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Consumer
 * @date 2021/11/5 10:45
 * @desc 消费者买车
 **/
public class Consumer {

    public static void main(String[] args) {

        // 接口,实现类创建
        System.out.println("==============类创建===============");

        Car wuling = new WuLing();
        wuling.getName();

        Car tesla = new Tesla();
        tesla.getName();

        // 用工厂创建
        System.out.println("============静态工厂创建==============");
        Car c1 = CarFactory.getCar("五菱");
        c1.getName();
        Car c2 = CarFactory.getCar("特斯拉");
        c2.getName();

    }
}
