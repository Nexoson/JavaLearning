package com.max.javaplus.leetcode.interview_q;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Test01
 * @date 2021/8/16 15:32
 * @desc 如何 a==1 && a==2 && a==3 是 true 地址 https://mp.weixin.qq.com/s/pNybiyBeGOiC6JUP7rhqlw
 **/
public class Question01 {

    @Test
    public void test01() throws NoSuchFieldException, IllegalAccessException {

        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);

        // array[129] is 1
        array[130] = array[129];
        // set 2 to be 1
        array[131] = array[129];
        // set 3 to be 1
        Integer a = 1;

        if (a.equals(1) && a.equals(2) && a.equals(3)) {
            System.out.println("success");
        }

        Integer[] array1 = (Integer[]) c.get(cache);
        System.out.println(array1.length);
    }

}
