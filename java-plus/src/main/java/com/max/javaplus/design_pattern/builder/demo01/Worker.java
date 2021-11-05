package com.max.javaplus.design_pattern.builder.demo01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Worker
 * @date 2021/11/5 20:36
 * @desc 具体的建造者: 工人
 **/
public class Worker extends Builder {
    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setProductA("打地基");
        System.out.println("打地基");
    }

    @Override
    void buildB() {
        product.setProductB("扎钢筋");
        System.out.println("扎钢筋");
    }

    @Override
    void buildC() {
        product.setProductC("浇灌水泥");
        System.out.println("浇灌水泥");
    }

    @Override
    void buildD() {
        product.setProductD("铺水电");
        System.out.println("铺水电");
    }

    @Override
    void buildE() {
        product.setProductE("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product createProduct() {
        return product;
    }
}
