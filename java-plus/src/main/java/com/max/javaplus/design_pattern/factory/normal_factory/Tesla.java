package com.max.javaplus.design_pattern.factory.normal_factory;


/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Tesla
 * @date 2021/11/5 10:42
 * @desc 特斯拉汽车
 **/
public class Tesla implements Car{
    @Override
    public void getName() {
        System.out.println("美国帕洛阿托特斯拉汽车");
    }
}
