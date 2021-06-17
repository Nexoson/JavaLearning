package com.max.java8.stream.chapter07;

import com.alibaba.fastjson.JSON;
import com.max.java8.stream.common.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className StreamCollectTest
 * @date 2021/4/21 10:09
 * @desc collect，收集 从字面上去理解，就是把一个流收集起来，最终可以是收集成一个值也可以收集成一个新的集合
 **/
public class StreamCollectTest {

    /**
     * collect主要依赖java.util.stream.Collectors类内置的静态方法。
     * <p>
     * 归集(toList/toSet/toMap)
     **/
    @Test
    public void test01() {
        /**
         * 因为流不存储数据，那么在流中的数据完成处理后，
         * 需要将流中的数据重新归集到新的集合里。
         * toList、toSet和toMap比较常用，
         * 另外还有toCollection、toConcurrentMap等复杂一些的用法
         **/
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        List<Person> personList = Person.getPersonList();
        Map<?, Integer> map = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, Person::getSalary));
        Map<?, Person> map1 = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));

        System.out.println("toList:" + listNew);
        System.out.println("toSet:" + set);
        System.out.println("toMap:" + map);
        System.out.println("toMap:" + map1);
    }

    /**
     * 统计(count/averaging)
     * Collectors提供了一系列用于数据统计的静态方法：
     * <p>
     * 计数：count
     * 平均值：averagingInt、averagingLong、averagingDouble
     * 最值：maxBy、minBy
     * 求和：summingInt、summingLong、summingDouble
     * 统计以上所有：summarizingInt、summarizingLong、summarizingDouble
     * <p>
     * 案例：统计员工人数、平均工资、工资总额、最高工资
     **/
    @Test
    public void test02() {
        List<Person> personList = Person.getPersonList();
        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
//        Long count = personList.stream().count();
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        IntSummaryStatistics sum = personList.stream().collect(Collectors.summarizingInt(Person::getSalary));
        // 一次性统计所有工资
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工最高工资：" + max.get());
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);
    }

    /**
     * 分组(partitioningBy/groupingBy)
     * <p>
     * 分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
     * 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     * <p>
     * 案例：将员工按薪资是否高于8000分为两部分；将员工按性别和地区分组
     **/
    @Test
    public void test03() {
        List<Person> personList = Person.getPersonList();

        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);
        System.out.println("员工按性别、地区：" + JSON.toJSONString(group2));
    }


    /**
     * 接合(joining)
     * <p>
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串
     **/
    @Test
    public void test04() {
        List<Person> personList = Person.getPersonList();

        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + names);

        List<String> list = Arrays.asList("A", "B", "C");
        String collect = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + collect);
    }


    /**
     * 归约(reducing)
     *
     * Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持
     **/
    @Test
    public void test05(){
        List<Person> personList = Person.getPersonList();

        // 每个员工减去起征点后的薪资之和
//        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        Integer sum = personList.stream().map(Person::getSalary).reduce(0, (i, j) -> (i + j - 5000));
        /**
         * 个人理解: 规约操作时 增加了锚点(元素)0,  集合内任意两个元素相加会增加一个-5000的运算,
         * 按道理来说应该会少一次-5000操作,但是因为增加了一个元素0进行操作,所以规避了这个问题
         **/
        System.out.println("员工免税薪资总和：" + sum);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());
    }
}
