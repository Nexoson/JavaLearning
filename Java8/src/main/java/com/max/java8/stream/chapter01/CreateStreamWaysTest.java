package com.max.java8.stream.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName TestCode
 * @Auther huangX
 * @Date 2021/4/10 20:03
 * @Version 1.0
 * @Descripition 创建流的几种方式
 **/
@Slf4j
public class CreateStreamWaysTest {
    public static void main(String[] args) {
    }

    @Test
    public void method01() {
        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = list.stream();
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();
    }

    @Test
    public void method02() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        IntStream stream = Arrays.stream(array);
    }

    @Test
    public void method03() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream1 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream1.forEach(System.out::println);

        Stream<Double> stream2 = Stream.generate(Math::random).limit(3);
        stream2.forEach(System.out::println);
    }


    /**
     * 顺序流转并行流
     **/
    @Test
    public void method04() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11, 13);
        Optional<Integer> findFirst = list.stream().parallel().filter(x -> x > 6).findFirst();
    }

}
