package com.max.javaplus.design_pattern.factory.simple_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className CarFactory
 * @date 2021/11/5 10:36
 * @desc 简单工厂(静态工厂)
 **/
public class CarFactory {

    public static Car getCar(String name) {
        if (name.equals("五菱")) {
            return new WuLing();
        } else if (name.equals("特斯拉")) {
            return new Tesla();
        } else {
            return null;
        }

    }
}
