package com.max.javaplus.design_pattern.factory_pattern.abstract_factory;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className IPhoneProduct
 * @date 2021/11/5 11:44
 * @desc 手机接口
 **/
public interface IPhoneProduct {
    /**
     * 开机
     **/
    void powerOn();
    /**
     * 关机
     **/
    void powerOff();
    /**
     * 打电话
     **/
    void call();
    /**
     * 发短信
     **/
    void seanSMS();
}
