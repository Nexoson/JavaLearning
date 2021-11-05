package com.max.javaplus.design_pattern.builder.demo01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Builder
 * @date 2021/11/5 20:31
 * @desc  抽象的建造者: 方法
 **/
public abstract class Builder {
    /**
     * 打地基
     **/
    abstract void buildA();

    /**
     * 扎钢筋
     **/
    abstract void buildB();

    /**
     * 浇灌水泥
     **/
    abstract void buildC();

    /**
     * 铺水电
     **/
    abstract void buildD();

    /**
     * 粉刷
     **/
    abstract void buildE();

    /**
     * 完工
     **/
    abstract Product createProduct();
}
