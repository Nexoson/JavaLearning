package com.max.javaplus.design_pattern.builder.demo02;


/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Builder
 * @date 2021/11/5 20:53
 * @desc 图纸,建造方法
 **/
public abstract class Builder {
    /**
     * 鸡肉汉堡
     **/
    abstract Builder buildA(String msg);

    /**
     * 柠檬可乐
     **/
    abstract Builder buildB(String msg);

    /**
     * 鸡肉卷
     **/
    abstract Builder buildC(String msg);

    /**
     * 椒盐鸡块
     **/
    abstract Builder buildD(String msg);

    /**
     * 薯条
     **/
    abstract Builder buildE(String msg);

    /**
     * 出餐
     **/
    abstract Product createProduct();
}
