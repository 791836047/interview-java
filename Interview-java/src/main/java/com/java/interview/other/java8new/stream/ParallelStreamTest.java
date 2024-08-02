package com.java.interview.other.java8new.stream;

import java.util.Arrays;

/**
 * @author liaowenhui
 * @date 2022/1/11 14:59
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        //测试parallelStream开多少个线程
        Integer[] array = new Integer[]{1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        //加上主线程一共开8个线程
        Arrays.asList(array).parallelStream().forEach(i -> {
            System.out.println(Thread.currentThread().getName() + " num:" + i);
        });
    }
}
