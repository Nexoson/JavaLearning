package com.max.java8.optional.chapter01;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className OptionalTest05
 * @date 2021/4/25 14:55
 * @desc filter(Predicate < ? super T > predicate)
 **/
public class OptionalTest05 {


    @Test
    public void test01() {
        User user = new User();
        user.setName("大威天龙");

        Optional<User> optionUser = Optional.ofNullable(user).filter(u -> u.getName().length() < 3);
        optionUser.ifPresent(value -> System.out.println(value.getName()));
    }

}
