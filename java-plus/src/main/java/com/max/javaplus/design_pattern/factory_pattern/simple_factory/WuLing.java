package com.max.javaplus.design_pattern.factory_pattern.simple_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className WuLing
 * @date 2021/11/5 10:40
 * @desc 五菱汽车
 **/
public class WuLing implements Car {
    @Override
    public void getName() {
        System.out.println("广西柳州五菱汽车");
    }
}
