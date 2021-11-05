package com.max.javaplus.design_pattern.builder.demo01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Director
 * @date 2021/11/5 20:41
 * @desc 指挥: 核心 负责指挥构建一个工程,工程如何构建,由它决定
 **/
public class Director {

    /**
     * 指挥工人按照图纸建造房子
     **/
    public Product command(Builder builder) {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        builder.buildE();
        return builder.createProduct();
    }
}
