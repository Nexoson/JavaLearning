package com.max.javaplus.design_pattern.factory_pattern.normal_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className WulingFactory
 * @date 2021/11/5 11:30
 * @desc
 **/
public class WulingFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
