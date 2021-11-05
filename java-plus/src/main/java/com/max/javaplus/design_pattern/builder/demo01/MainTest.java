package com.max.javaplus.design_pattern.builder.demo01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className main
 * @date 2021/11/5 20:43
 * @desc 检验成果
 **/
public class MainTest {

    public static void main(String[] args) {

        Director director = new Director();
        Product product = director.command(new Worker());
        System.out.println(product.toString());
    }
}
