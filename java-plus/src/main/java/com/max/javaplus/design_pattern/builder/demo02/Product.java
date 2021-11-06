package com.max.javaplus.design_pattern.builder.demo02;

import lombok.Data;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Product
 * @date 2021/11/5 20:19
 * @desc 产品, 有默认套餐
 **/
@Data
public class Product {

    private String productA = "鸡肉汉堡";
    private String productB = "柠檬可乐";
    private String productC = "鸡肉卷";
    private String productD = "椒盐鸡块";
    private String productE = "薯条";
}
