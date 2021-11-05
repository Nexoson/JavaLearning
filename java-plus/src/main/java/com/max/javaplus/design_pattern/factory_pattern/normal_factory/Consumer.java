package com.max.javaplus.design_pattern.factory_pattern.normal_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Consumer
 * @date 2021/11/5 11:35
 * @desc
 **/
public class Consumer {
    public static void main(String[] args) {
        Car c1 = new WulingFactory().getCar();
        c1.getName();
        Car c2 = new TeslaFactory().getCar();
        c2.getName();
    }
}
