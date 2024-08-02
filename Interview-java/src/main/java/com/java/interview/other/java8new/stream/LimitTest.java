package com.java.interview.other.java8new.stream;

import java.util.stream.Stream;

/**
 * limit
 * @author liaowenhui
 * @date 2022/1/11 15:06
 */
public class LimitTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        //根据起始值seed(0)，每次生成一个指定递增值（n+1）的数，limit(5)用于截断流的长度，即只获取前5个元素。
        Stream.iterate(0, n -> n + 1).limit(5).forEach(a -> {
            System.out.println(a);
        });
        //Stream.iterate(),指定一个常量seed，生成从seed到常量f（由UnaryOperator返回的值得到）的流
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);
    }
}
