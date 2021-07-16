package com.max.javaplus.common_utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className JavaInnerUtils
 * @date 2021/7/16 10:24
 * @desc Java 自带工具类
 **/
public class JavaInnerUtilsTest {

    /**
     * 如何把list集合拼接成以逗号分隔的字符串 a,b,c
     **/
    @Test
    public void test01() {
        List<String> list = Arrays.asList("a", "b", "c");
        // 第一种方法 用stream流
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
        // 第二种方法 String join
        String join = String.join(",", list);
        System.out.println(join);
    }

    /**
     * 比较两个字符串是否相等，忽略大小写
     **/
    @Test
    public void test02() {
        String A = "AAA";
        String a = "aaa";

        System.out.println(A.equalsIgnoreCase(a));
    }

    /**
     * 两个List集合,交集,合集,并集,差集
     **/
    @Test
    public void test03() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        // 交集
/*        list1.retainAll(list2);
        System.out.println("交集: " + list1);*/
        // 并集
/*        list1.addAll(list2);
        System.out.println("合集: " + list1);*/

        // 去重并集
/*        list1.removeAll(list2);
        list1.addAll(list2);
        System.out.println("去重并集: " + list1);*/

        // 差集
        list1.removeAll(list2);
        System.out.println(list1);
    }


    /**
     * 比较两个对象是否相等(对null对象进行处理)
     **/
    @Test
    public void test04(){
        String A = "AAA";
//        String B = "AAA";
        String B = null;
        System.out.println(Objects.equals(A, B));
    }

    /**
     * 字符串判空
     **/
    @Test
    public void test05(){
        StringUtils.isEmpty("AAA");
        StringUtils.isNotEmpty("AAA");
        // 判空的时候，会去除字符串中的空白字符，比如空格、换行、制表符
        StringUtils.isBlank("AAA");
        StringUtils.isNotBlank("AAA");

//        String[] css = {"A","B"};
        String[] css = {};
        System.out.println(StringUtils.isAllBlank(css));
    }
}
