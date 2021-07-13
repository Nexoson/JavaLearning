package com.max.javaplus.devLab.other.test;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className keywordTest
 * @date 2021/6/22 20:08
 * @desc Java
 **/
public class KeywordTest {

    public static void main(String[] args) {
        boolean f1 = true;
        boolean f2 = true;

        if (f1 | f2) {
            System.out.println("hello lido");
        }
    }

    @Test
    public void test01() {
        int num = 2;

        if (true) {
            num--;
        }
        if (true) {
            num--;
        }
        System.out.println(num);
    }

    @Test
    public void test02() {
        String a = "aa";
        if (a.equals(null)) {
            System.out.println("1111111");
        }
        System.out.println("2222222");

    }

    @Test
    public void test03() {
        Cat cat = new Cat();
        System.out.println(ObjectUtils.allNotNull(cat));
    }

    @Test
    public void test04() {
        String testStr = "\"IE06016287RU\"";
        String parse = JSONObject.parse(testStr).toString();
        System.out.println(parse);
    }


    @Data
    public class Cat {
        public String name;
        public Integer age;
    }
}
