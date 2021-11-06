package com.max.javaplus.design_pattern.builder.demo02;

/**
 * @author max66
 */
public class MainTest {

    public static void main(String[] args) {
        // 服务员
        Worker worker = new Worker();
        worker.buildA("牛肉堡").buildB("雪碧");
        Product product = worker.createProduct();

        System.out.println(product.toString());
    }
}
