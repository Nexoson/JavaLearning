package com.max.javaplus.design_pattern.factory.abstract_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Consumer
 * @date 2021/11/5 11:57
 * @desc 消费者
 **/
public class Consumer {
    public static void main(String[] args) {
        // 抽象工厂方法测试
        HaweiProductFactory haweiProductFactory = new HaweiProductFactory();
        IPhoneProduct p1 = haweiProductFactory.getPhone();
        p1.powerOn();
        p1.call();
        p1.seanSMS();
        p1.powerOff();
        IRouteProduct r1 = haweiProductFactory.getRoute();
        r1.openWifi();

        MiProductFactory miProductFactory = new MiProductFactory();
        IPhoneProduct p2 = miProductFactory.getPhone();
        p2.powerOn();
        p2.call();
        p2.seanSMS();
        p2.powerOff();
        IRouteProduct r2 = miProductFactory.getRoute();
        r2.openWifi();

    }
}
