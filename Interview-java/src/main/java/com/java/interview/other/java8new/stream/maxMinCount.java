package com.java.interview.other.java8new.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author liaowenhui
 * @date 2022/1/11 15:45
 */
public class maxMinCount {
    public static void main(String[] args) {
        System.out.println("-------------------示例一-------------------------------------");
        /**
         * 示例一
         */
        List<String> list = Arrays.asList("Java", "Python", "Go", "C","Pascal");

        //如果存在字符串长度相同的话，取第一个
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

        System.out.println("-------------------示例二-------------------------------------");

        /**
         * 示例二
         */
        List<Integer> list1 = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max2 = list1.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max3 = list1.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max2.get());
        System.out.println("自定义排序的最大值：" + max3.get());

        System.out.println("-------------------示例三-------------------------------------");

        /**
         * 示例三 员工工资最大值
         */
        List<Person> personList = Person.defaultDate();
        Optional<Person> max4 = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + max4.get().getSalary());

        System.out.println("-------------------示例四-------------------------------------");

        /**
         * 示例四 计算Integer集合中大于6的元素的个数
         */
        List<Integer> list2 = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list2.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);

    }
}
