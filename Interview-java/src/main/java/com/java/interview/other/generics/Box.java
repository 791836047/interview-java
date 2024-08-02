package com.java.interview.other.generics;

/**
 * 泛型类
 * @author liaowenhui
 * @date 2022/7/6 11:47
 */
public class Box<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.add(10);
        stringBox.add("菜鸟教程");

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}
