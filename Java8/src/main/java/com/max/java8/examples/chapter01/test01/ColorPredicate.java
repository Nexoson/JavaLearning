package com.max.java8.examples.chapter01.test01;

import com.max.java8.examples.chapter01.Product;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className ColorPredicate
 * @date 2021/4/25 16:48
 * @desc
 **/
public class ColorPredicate implements MyPredicate<Product> {

    private static final String COLOR = "红";

    @Override
    public boolean test(Product product) {
        return COLOR.equals(product.getColor());
    }
}
