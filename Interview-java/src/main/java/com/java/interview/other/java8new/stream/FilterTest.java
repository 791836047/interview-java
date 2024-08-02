package com.java.interview.other.java8new.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 过滤，是按照一定的规则校验流中的元素，将!!符合条件!!的元素提取到新的流中的操作。
 * @author liaowenhui
 * @date 2022/1/11 15:25
 */
public class FilterTest {
    public static void main(String[] args) {
        /**
         * 案例1
         */
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        //过滤出大于7的数据
        stream.filter(x -> x > 7).forEach(x1 -> System.out.println(x1 + " "));

        System.out.println("---------------------------------------------");

        /**
         * 案例2 筛选员工中工资高于8000的人，并形成新的集合。
         */
        //获取默认数据
        List<Person> people = Person.defaultDate();

        List<String> fiterList = people.stream()
                .filter(x -> x.getSalary() > 8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("高于8000的员工姓名：" + fiterList);

    }
}
