package com.max.java8.examples.chapter01.test01;

import com.max.java8.examples.chapter01.Product;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className PricePredicate
 * @date 2021/4/25 16:50
 * @desc
 **/
public class PricePredicate implements MyPredicate<Product> {

    @Override
    public boolean test(Product product) {
        return product.getPrice() > 8000;
    }
}
