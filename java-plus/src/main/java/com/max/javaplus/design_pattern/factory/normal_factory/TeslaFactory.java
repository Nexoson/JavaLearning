package com.max.javaplus.design_pattern.factory.normal_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className TeslaFactory
 * @date 2021/11/5 11:32
 * @desc
 **/
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
