package com.java.interview.other.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符
 * @author liaowenhui
 * @date 2022/7/6 16:04
 */
public class GenericTest {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

        //getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3
    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}
