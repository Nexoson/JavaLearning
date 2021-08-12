package com.max.javaplus.common_utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className BlankOrEmpty
 * @date 2021/8/12 17:17
 * @desc BlankOrEmpty
 **/
public class BlankOrEmptyTest {


    /**
     * StringUtils.isEmpty() 为空
     **/
    @Test
    public void test01() {
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("bbb"));
        System.out.println(StringUtils.isEmpty(" bbb "));
    }


    /**
     * StringUtils.isNotEmpty() 永远都不为空
     **/
    @Test
    public void test02() {
//        !isEmpty(cs);
        System.out.println(StringUtils.isNotEmpty(" "));
        System.out.println(StringUtils.isNotEmpty(""));
    }


    /**
     * StringUtils.isAnyEmpty() 有任意一个为空
     **/
    @Test
    public void test03() {
        System.out.println(StringUtils.isAnyEmpty(null));
        System.out.println(StringUtils.isAnyEmpty(null, "foo"));
        System.out.println(StringUtils.isAnyEmpty("", "bar"));
        System.out.println(StringUtils.isAnyEmpty("bob", ""));
        System.out.println(StringUtils.isAnyEmpty(" bob ", null));
        System.out.println(StringUtils.isAnyEmpty(" ", "bar"));
        System.out.println(StringUtils.isAnyEmpty("foo", "bar"));
    }


    /**
     * StringUtils.isNoneEmpty() 相当于!isAnyEmpty(css) , 必须所有的值都不为空才返回true (慎用)
     **/
    @Test
    public void test04() {
        System.out.println(StringUtils.isNoneEmpty(null));
        System.out.println(StringUtils.isNoneEmpty((CharSequence) null));
        System.out.println(StringUtils.isNoneEmpty(null, "foo"));
        System.out.println(StringUtils.isNoneEmpty("", "bar"));
        System.out.println(StringUtils.isNoneEmpty("bob", ""));
        System.out.println(StringUtils.isNoneEmpty(" bob ", null));
        System.out.println(StringUtils.isNoneEmpty(" ", "bar"));
        System.out.println(StringUtils.isNoneEmpty("foo", "bar"));
    }


    /**
     * StringUtils.isBlank()  是否为真空值(空格或者空值)
     **/
    @Test
    public void test05() {
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("bob"));
        System.out.println(StringUtils.isBlank(" bob "));
    }


    /**
     * StringUtils.isNotBlank()
     * 是否真的不为空,不是空格或者空值 ,相当于!isBlank();
     **/
    @Test
    public void test06() {

    }

    /**
     * StringUtils.isAnyBlank()
     * 是否包含任何真空值(包含空格或空值)
     **/
    @Test
    public void test07() {
        // 与期望值不一样
        System.out.println(StringUtils.isAnyBlank(null));

        System.out.println(StringUtils.isAnyBlank(null, "foo"));
        System.out.println(StringUtils.isAnyBlank(null, null));
        System.out.println(StringUtils.isAnyBlank("", "bar"));
        System.out.println(StringUtils.isAnyBlank("bob", ""));
        System.out.println(StringUtils.isAnyBlank(" bob ", null));
        System.out.println(StringUtils.isAnyBlank(" ", "bar"));
        System.out.println(StringUtils.isAnyBlank("foo", "bar"));
    }


    /**
     * StringUtils.isNoneBlank()
     * <p>
     * 是否全部都不包含空值或空格
     **/
    @Test
    public void test08() {
        System.out.println(StringUtils.isNoneBlank(null));
        System.out.println(StringUtils.isNoneBlank(null, "foo"));
        System.out.println(StringUtils.isNoneBlank(null, null));
        System.out.println(StringUtils.isNoneBlank("", "bar"));
        System.out.println(StringUtils.isNoneBlank("bob", ""));
        System.out.println(StringUtils.isNoneBlank(" bob ", null));
        System.out.println(StringUtils.isNoneBlank(" ", "bar"));
        System.out.println(StringUtils.isNoneBlank("foo", "bar"));
    }

}
