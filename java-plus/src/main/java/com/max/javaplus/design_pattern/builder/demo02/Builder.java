package com.max.javaplus.design_pattern.builder.demo02;

import com.max.javaplus.design_pattern.builder.demo01.Product;

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
    abstract void buildA(String msg);

    /**
     * 柠檬可乐
     **/
    abstract void buildB(String msg);

    /**
     * 鸡肉卷
     **/
    abstract void buildC(String msg);

    /**
     * 椒盐鸡块
     **/
    abstract void buildD(String msg);

    /**
     * 薯条
     **/
    abstract void buildE(String msg);

    /**
     * 出餐
     **/
    abstract Product createProduct();
}
