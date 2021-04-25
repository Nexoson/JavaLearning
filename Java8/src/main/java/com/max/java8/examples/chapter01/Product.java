package com.max.java8.examples.chapter01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Product
 * @date 2021/4/25 16:23
 * @desc 商品信息
 **/

@Data
@AllArgsConstructor
public class Product implements Serializable {

    /**
     * 颜色
     **/
    private String color;

    /**
     * 价格
     **/
    private Integer price;


    public static List<Product> getBaseProductList() {
        List<Product> products = new ArrayList<>(8);
        products.add(new Product("红", 8000));
        products.add(new Product("白", 2000));
        products.add(new Product("蓝", 1000));
        products.add(new Product("紫", 18000));
        products.add(new Product("红", 9000));
        products.add(new Product("红", 6000));
        products.add(new Product("绿", 28000));
        products.add(new Product("黄", 38000));
        products.add(new Product("红", 19000));
        return products;
    }

}
