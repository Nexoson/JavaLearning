package com.max.javaplus.design_pattern.factory.abstract_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MiPhone
 * @date 2021/11/5 11:45
 * @desc 小米手机
 **/
public class MiPhone implements IPhoneProduct {
    @Override
    public void powerOn() {
        System.out.println("小米手机开机");
    }

    @Override
    public void powerOff() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void seanSMS() {
        System.out.println("小米手机发短信");
    }
}
