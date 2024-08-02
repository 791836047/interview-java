package com.java.interview.other.java8new.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowenhui
 * @date 2022/1/11 15:28
 */
@Data
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 薪资
     */
    private int salary;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地区
     */
    private String city;

    /**
     * 构造方法
     * @param name
     * @param salary
     * @param age
     * @param sex
     * @param area
     */
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.city = area;
    }

    public static List<Person> defaultDate() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "ShangHai"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "BeiJing"));
        personList.add(new Person("Bob", 9500, 25, "male", "ShenZhen"));
        personList.add(new Person("cindy", 7900, 26, "female", "Guangzhou"));
        return personList;

    }

}

