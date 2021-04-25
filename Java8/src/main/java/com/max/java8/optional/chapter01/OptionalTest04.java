package com.max.java8.optional.chapter01;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className OptionalTest04
 * @date 2021/4/23 19:57
 * @desc isPresent()和ifPresent(Consumer < ? super T > consumer)
 **/
public class OptionalTest04 {

    @Test
    public void test01() {

        User user = new User();
        user = null;

        boolean isPresent = Optional.ofNullable(user).isPresent();
        System.out.println("user 不为空: " + isPresent);

        Optional.ofNullable(user).ifPresent(u -> {
            System.out.println("ifPresent判断 user不为空");
        });

    }
}
