package com.max.javaplus.common_utils;

import com.google.common.collect.*;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.*;
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
    public void test04() {
        String A = "AAA";
//        String B = "AAA";
        String B = null;
        System.out.println(Objects.equals(A, B));
    }

    /**
     * 字符串判空
     **/
    @Test
    public void test05() {
        StringUtils.isEmpty("AAA");
        StringUtils.isNotEmpty("AAA");
        // 判空的时候，会去除字符串中的空白字符，比如空格、换行、制表符
        StringUtils.isBlank("AAA");
        StringUtils.isNotBlank("AAA");

//        String[] css = {"A","B"};
        String[] css = {};
        System.out.println(StringUtils.isAllBlank(css));
    }

    /**
     * 首字母转大写,转小写
     **/
    @Test
    public void test06() {
        String str = "huang";
        System.out.println(StringUtils.capitalize(str));

        String AAA = "AAA";
        System.out.println(StringUtils.uncapitalize(AAA));
    }

    /**
     * 重复拼接字符串
     **/
    @Test
    public void test07() {
        System.out.println(StringUtils.repeat("abc", 3));
    }

    /**
     * 格式化日期
     **/
    @Test
    public void test08() throws ParseException {
        // Date类型转String类型
        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        // 输出 2021-05-01 01:01:01
        System.out.println(date);


        // String类型转Date类型
        Date date1 = DateUtils.parseDate("2021-08-01 01:01:01", "yyyy-MM-dd HH:mm:ss");

        // 计算2小时后的日期
        System.out.println(DateUtils.addHours(new Date(), 2));
    }

    /**
     * 包装临时对象
     **/
    @Test
    public void test09() {

        // 返回两个字段
        ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "huang");
        System.out.println(pair.getLeft() + pair.getRight());

        // 返回三个字段
        ImmutableTriple<Integer, String, Date> max = ImmutableTriple.of(1, "max", new Date());
        System.out.println(max.getLeft() + "," + max.getMiddle() + "," + max.getRight());
    }


    /**
     * common-beanutils 操作对象
     **/
    @Test
    public void test10() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "id", 1);
        BeanUtils.setProperty(user, "name", "max");
        System.out.println(BeanUtils.getProperty(user, "name"));
        System.out.println(user);

    }


    /**
     * 对象和map互转
     **/
    @Test
    public void test11() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "id", 1);
        BeanUtils.setProperty(user, "name", "max");
        // 对象转map
        Map<String, String> map = BeanUtils.describe(user);
        System.out.println(map);
        // map转对象
        User newUser = new User();
        BeanUtils.populate(newUser, map);
        // 输出 {"id":1,"name":"max"}
        System.out.println(newUser);

    }


    /**
     * 对象和map互转
     **/
    @Test
    public void test12() throws IOException {
        File file = new File("demo.txt");
        // 读取文件
        List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
        // 写入文件
        FileUtils.writeLines(new File("demo2.txt"), lines);
        // 复制文件
//        FileUtils.copyFile(srcFile, destFile);
    }

    /**
     * 创建集合
     **/
    @Test
    public void test13() {
        List<String> list = Lists.newArrayList();
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);

        // 反转list
        List<Integer> reverse = Lists.reverse(list1);
        System.out.println(reverse);
        // list集合元素太多，可以分成若干个集合，每个集合10个元素
        List<List<Integer>> partition = Lists.partition(list1, 10);

        Map<String, String> map = Maps.newHashMap();
        Set<String> set = Sets.newHashSet();
    }

    /**
     * 黑科技集合01
     **/
    @Test
    public void test14() {
        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("key", 1);
        map.put("key", 2);
        Collection<Integer> values = map.get("key");
        // 输出 {"key":[1,2]}
        System.out.println(map);
        // 还能返回你以前使用的臃肿的Map
        Map<String, Collection<Integer>> collectionMap = map.asMap();
    }

    /**
     * 黑科技集合02
     **/
    @Test
    public void test15() {
        BiMap<String, String> biMap = HashBiMap.create();
        // 如果value重复，put方法会抛异常，除非用forcePut方法
        biMap.put("key", "value");
        // 输出 {"key":"value"}
        System.out.println(biMap);
        // 既然value不能重复，何不实现个翻转key/value的方法，已经有了
        BiMap<String, String> inverse = biMap.inverse();
        // 输出 {"value":"key"}
        System.out.println(inverse);
    }

    /**
     * 黑科技集合03
     **/
    @Test
    public void test16() {
        // 一批用户，同时按年龄和性别分组
        Table<Integer, String, String> table = HashBasedTable.create();
        table.put(18, "男", "yideng");
        table.put(18, "女", "Lily");
        // 输出 yideng
        System.out.println(table.get(18, "男"));
        // 这其实是一个二维的Map，可以查看行数据
        Map<String, String> row = table.row(18);
        // 输出 {"男":"yideng","女":"Lily"}
        System.out.println(row);
        // 查看列数据
        Map<Integer, String> column = table.column("男");
        // 输出 {18:"yideng"}
        System.out.println(column);
    }

    /**
     * 黑科技集合04
     **/
    @Test
    public void test17() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("apple");
        multiset.add("apple");
        multiset.add("orange");
        // 输出 2
        System.out.println(multiset.count("apple"));
        // 查看去重的元素
        Set<String> set = multiset.elementSet();
        // 输出 ["orange","apple"]
        System.out.println(set);
        // 还能查看没有去重的元素
        Iterator<String> iterator = multiset.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 还能手动设置某个元素出现的次数
        multiset.setCount("apple", 5);
    }

    /**
     * User for test10
     **/
    @Data
    public class User {
        private Integer id;
        private String name;

    }
}
