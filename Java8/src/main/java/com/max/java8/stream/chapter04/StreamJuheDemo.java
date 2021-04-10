package com.max.java8.stream.chapter04;

import com.max.java8.stream.common.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName StreamJuheDemo
 * @Auther huangX
 * @Date 2021/4/10 22:19
 * @Version 1.0
 * @Descripition 聚合（max/min/count)
 **/
public class StreamJuheDemo {


    /**
     * 获取String集合中最长的元素
     **/
    @Test
    public void test01() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }


    /**
     * 案例二：获取Integer集合中的最大值
     **/
    @Test
    public void test02() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max1.get());
    }


    /**
     * 获取员工工资最高的人
     **/
    @Test
    public void test03() {
        List<Person> personList = Person.getPersonList();
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + max.get().getSalary());
    }


    /**
     * 计算Integer集合中大于6的元素的个数
     **/
    @Test
    public void test04() {
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }


}
