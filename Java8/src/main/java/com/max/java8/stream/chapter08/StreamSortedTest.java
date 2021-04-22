package com.max.java8.stream.chapter08;

import com.max.java8.stream.common.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className StreamSortedTest
 * @date 2021/4/21 11:45
 * @desc 排序(sorted)
 **/
public class StreamSortedTest {
    /**
     * sorted，中间操作。有两种排序：
     * <p>
     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     * <p>
     * 案例：将员工按工资由高到低（工资一样则按年龄由大到小）排序
     **/
    @Test
    public void test01() {

        List<Person> personList = Person.getPersonList();

        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        // 按工资倒序排序
        List<Person> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<Person> newList3 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).collect(Collectors.toList());
//        List<String> newList3 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());

        // 先按工资再按年龄自定义排序（降序）
        List<Person> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).collect(Collectors.toList());

        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄升序排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);
    }


    /**
     * 提取/组合
     * 流也可以进行合并、去重、限制、跳过等操作
     **/
    @Test
    public void test02() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);

        // concat:合并两个流  distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit:限制从流中获取n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip:跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 3).skip(1).limit(5).collect(Collectors.toList());
        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }
}
