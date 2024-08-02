package com.java.interview.other.java8new.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 遍历/匹配foreach/find/match
 *
 * @author liaowenhui
 * @date 2022/1/6 13:22
 */
public class ForeachFindMatchTest {
    /**
     * Stream中的元素是以Optional类型存在的
     */
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);

        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        System.out.println("匹配第一个值：" + findFirst.get());

        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        System.out.println("匹配任意一个值：" + findAny.get());

        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("是否存在大于6的值：" + anyMatch);

    }
}
