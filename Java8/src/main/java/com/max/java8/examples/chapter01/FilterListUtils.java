package com.max.java8.examples.chapter01;

import com.max.java8.examples.chapter01.test01.MyPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className FilterListUtils
 * @date 2021/4/25 16:58
 * @desc 集合数据的自定义排序
 **/
public class FilterListUtils {

    /**
     * 1.使用设计模式  使用自定义接口进行筛选数据 -> test01
     * 2.使用匿名内部类
     **/
    public static List<Product> filterProductByPredicate(List<Product> list, MyPredicate<Product> mp) {
        List<Product> products = new ArrayList<>();
        for (Product product : list) {
            if (mp.test(product)) {
                products.add(product);
            }
        }
        return products;
    }
}
