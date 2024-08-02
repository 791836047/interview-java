package com.java.interview.other.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型 消除强制转换
 * @author liaowenhui
 * @date 2022/7/6 16:21
 */
public class GenericTest2 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("hello");
        //没有泛型的时候得强制转换
        String o = (String) list.get(0);

        List<String> list2 = new ArrayList<>();
        list2.add("hello");
        String s = list2.get(0);
    }
}
