package com.java.interview.other.java8new.optional;

import java.util.Optional;

/**
 * map()
 * @author liaowenhui
 * @date 2023/8/10 14:22
 */
public class OptionalExample2 {
    public static void main(String[] args) {
        // 创建一个可能为 null 的Optional对象
        Optional<Person> personOptional = Optional.ofNullable(new Person("Alice", 30));

        // 使用map()对Optional中的值进行转换操作
        Optional<Integer> ageDoubledOptional = personOptional.map(person -> person.getAge() * 2);

        // 如果值存在，打印结果；否则打印提示信息
        ageDoubledOptional.ifPresent(age -> System.out.println("Doubled Age: " + age));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
