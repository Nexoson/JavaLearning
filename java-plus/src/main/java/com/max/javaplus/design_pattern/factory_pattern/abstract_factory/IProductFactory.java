package com.max.javaplus.design_pattern.factory_pattern.abstract_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className IProductFactory
 * @date 2021/11/5 11:54
 * @desc 产品工厂
 **/
public interface IProductFactory {
    /**
     * 生产手机
     **/
    IPhoneProduct getPhone();

    /**
     * 生产路由器
     **/
    IRouteProduct getRoute();
}
