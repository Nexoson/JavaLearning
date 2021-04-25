package com.max.java8.examples.chapter01;

import com.max.java8.examples.chapter01.test01.ColorPredicate;
import com.max.java8.examples.chapter01.test01.PricePredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MainTest
 * @date 2021/4/25 17:13
 * @desc
 **/
public class MainTest {


    @Test
    public void test01() {
        List<Product> baseProductList = Product.getBaseProductList();

        List<Product> products = FilterListUtils.filterProductByPredicate(baseProductList, new PricePredicate());
        System.out.println("价格过滤后数据");
        products.forEach(info -> System.out.println(info.toString()));
        System.out.println("颜色过滤后数据");
        products = FilterListUtils.filterProductByPredicate(products, new ColorPredicate());
        products.forEach(info -> System.out.println(info.toString()));
    }


}
