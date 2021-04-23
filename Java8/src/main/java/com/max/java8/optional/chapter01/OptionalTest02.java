package com.max.java8.optional.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className OptionalTest02
 * @date 2021/4/23 19:40
 * @desc
 **/

@Slf4j
public class OptionalTest02 {


    @Test
    public void test01() {
        /**
         * 这两个函数的区别：当user值不为null时，orElse函数依然会执行createUser()方法，
         * 而orElseGet函数并不会执行createUser()方法，大家可自行测试。
         **/
        User user = null;
        user = Optional.ofNullable(user).orElse(createUser(1));
        user = Optional.ofNullable(user).orElseGet(() -> createUser(2));


        /**
         * 至于orElseThrow，就是value值为null时,直接抛一个异常出去，用法如下所示
         **/
        user = null;
        try {
            Optional.ofNullable(user).orElseThrow(()->new Exception("用户不存在"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public User createUser(Integer mark) {
        System.out.println(mark+ "  user 构造函数");
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

}
