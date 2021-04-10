package com.max.java8.stream.chapter03;

import com.max.java8.stream.common.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamFliterDemo
 * @Auther huangX
 * @Date 2021/4/10 22:02
 * @Version 1.0
 * @Descripition 筛选（filter）
 **/
public class StreamFilterDemo {


    /**
     * 筛选出Integer集合中大于7的元素，并打印出来
     **/
    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(a -> a > 7).forEach(System.out::println);
    }

    @Test
    public void test02() {
        List<Person> personList = Person.getPersonList();
        List<String> filterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + filterList);
    }
}
