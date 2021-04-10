package com.max.java8.stream.chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamFlatMapDemo
 * @Auther huangX
 * @Date 2021/4/10 23:00
 * @Version 1.0
 * @Descripition 映射(map / flatMap)
 **/
public class StreamFlatMapDemo {


    /**
     * 英文字符串数组的元素全部改为大写
     * 整数数组每个元素+3
     **/
    @Test
    public void test01() {
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);
    }


}
