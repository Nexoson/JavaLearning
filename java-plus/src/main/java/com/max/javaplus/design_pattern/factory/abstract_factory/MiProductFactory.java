package com.max.javaplus.design_pattern.factory.abstract_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MiProductFactory
 * @date 2021/11/5 11:56
 * @desc 小米工厂
 **/
public class MiProductFactory implements IProductFactory{
    @Override
    public IPhoneProduct getPhone() {
        return new MiPhone();
    }

    @Override
    public IRouteProduct getRoute() {
        return new MiRoute();
    }
}
