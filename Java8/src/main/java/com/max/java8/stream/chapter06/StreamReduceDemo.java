package com.max.java8.stream.chapter06;

import com.max.java8.stream.common.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName StreamReduceDemo
 * @Auther huangX
 * @Date 2021/4/11 17:27
 * @Version 1.0
 * @Descripition 归约(reduce)
 **/
public class StreamReduceDemo {


    /**
     * 案例一：求Integer集合的元素之和、乘积和最大值。
     **/
    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);
        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值方式2
        Integer max2 = list.stream().reduce(1, Integer::max);
        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求最大值：" + max.get() + "," + max2);
    }

    @Test
    public void test02() {
        List<Person> personList = Person.getPersonList();
        // 求工资之和方式1
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3
        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
        // 求最高工资方式1
        // 求最高工资方式2
    }
}