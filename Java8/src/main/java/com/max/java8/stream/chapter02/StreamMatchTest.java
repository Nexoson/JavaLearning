package com.max.java8.stream.chapter02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName StreamMatchTest
 * @Auther huangX
 * @Date 2021/4/10 21:41
 * @Version 1.0
 * @Descripition 遍历/匹配（foreach/find/match）
 **/
public class StreamMatchTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 3).forEach(System.out::println);
        // 匹配第一个元素
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意(适用于并行流)
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean flag = list.stream().anyMatch(x -> x < 6);

        System.out.println("匹配第一个值：" + first.orElse(0));
        System.out.println("匹配第一个值：" + findAny.orElse(0));
        System.out.println("是否存在大于6的值：" + flag);
    }
}
