package com.max.javaplus.devLab.stream;

import lombok.Data;
import org.junit.Test;

import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className StreamTest01
 * @date 2021/6/4 10:14
 * @desc
 **/
public class StreamTest01 {

    /**
     * 验证空集合调用stream场景
     **/
    @Test
    public void test01() {

//        List<User> temp = new ArrayList<>();
        List<User> temp = null;
        System.out.println(temp.stream().findFirst().isPresent());

    }
    @Data
    public static class User {
        public String name;
        public Integer age;
    }

}
