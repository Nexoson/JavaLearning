package com.max.java8.examples.chapter01;

import com.max.java8.examples.chapter01.test01.ColorPredicate;
import com.max.java8.examples.chapter01.test01.MyPredicate;
import com.max.java8.examples.chapter01.test01.PricePredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MainTest
 * @date 2021/4/25 17:13
 * @desc https://blog.csdn.net/qq_29411737/article/details/80835658?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control
 **/
public class MainTest {


    /**
     * 使用设计模式 过滤数据
     **/
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

    /**
     * 使用匿名内部类 过滤数据
     **/
    @Test
    public void test02() {
        List<Product> baseList = Product.getBaseProductList();
        List<Product> products = FilterListUtils.filterProductByPredicate(baseList, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getPrice() > 8000;
            }
        });
        System.out.println("价格过滤后数据");
        products.forEach(info -> System.out.println(info.toString()));

        products = FilterListUtils.filterProductByPredicate(products, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return "红".equals(product.getColor());
            }
        });
        System.out.println("颜色过滤后数据");
        products.forEach(info -> System.out.println(info.toString()));

    }


    /**
     * 使用lambda表达式 筛选数据
     **/
    @Test
    public void test03() {
        List<Product> products = FilterListUtils.filterProductByPredicate(Product.getBaseProductList(), (p) -> p.getPrice() > 8000);
        products.forEach(info -> System.out.println(info.toString()));
    }


}
