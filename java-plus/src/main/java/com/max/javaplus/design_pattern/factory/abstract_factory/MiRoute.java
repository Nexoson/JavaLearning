package com.max.javaplus.design_pattern.factory.abstract_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MiRoute
 * @date 2021/11/5 11:53
 * @desc 小米路由器
 **/
public class MiRoute implements IRouteProduct{
    @Override
    public void openWifi() {
        System.out.println("小米1000M路由器");
    }
}
