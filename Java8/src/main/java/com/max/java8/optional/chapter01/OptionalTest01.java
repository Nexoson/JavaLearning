package com.max.java8.optional.chapter01;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className OptionalTest01
 * @date 2021/4/23 19:23
 * @desc Optional学习
 **/
public class OptionalTest01 {

    public static void main(String[] args) {
        int num = 1 == 1 ? 2 : 3;
        System.out.println(num);
    }


    /**
     * Optional.ofNullable() 与 Optional.of() 区别
     **/
    @Test
    public void test01(){

        Object obj = null;
        // Optional.ofNullable 传入null 进去 会返回 Optional包装的empty对象
        Optional.ofNullable(obj);

        // Optional.ofNullable 传入null 进去 会报空指针异常
        Optional.of(obj);

    }

}
