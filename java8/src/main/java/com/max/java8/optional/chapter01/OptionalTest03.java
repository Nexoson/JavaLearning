package com.max.java8.optional.chapter01;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className OptionalTest03
 * @date 2021/4/23 19:46
 * @desc map  flatMap
 **/
public class OptionalTest03 {

    /**
     * 这两个函数，在函数体上没什么区别。唯一区别的就是入参，
     * map函数所接受的入参类型为Function<? super T, ? extends U>，
     * 而flapMap的入参类型为Function<? super T, Optional<U>>。
     **/
    @Test
    public void test01() {
        User user = new User();
        user.setName("love story");
        String name = Optional.of(user).map(u -> u.getName()).get();
        System.out.println("name: " + name);
    }

    @Test
    public void test02() {
        UserFlat user = new UserFlat();
        user.setName("love story");
        String name = Optional.ofNullable(user).flatMap(u -> u.getName()).get();
        System.out.println("name: " + name);
    }


    public static class UserFlat {

        public UserFlat() {
        }

        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

    }

}
