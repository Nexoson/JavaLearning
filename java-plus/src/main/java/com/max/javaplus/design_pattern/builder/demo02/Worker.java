package com.max.javaplus.design_pattern.builder.demo02;


/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Worker
 * @date 2021/11/5 20:56
 * @desc 工人
 **/
public class Worker extends Builder{

    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    Builder buildA(String msg) {
        product.setProductA(msg);
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setProductB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setProductC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setProductD(msg);
        return this;
    }

    @Override
    Builder buildE(String msg) {
        product.setProductE(msg);
        return this;
    }

    @Override
    Product createProduct() {
        return product;
    }
}
