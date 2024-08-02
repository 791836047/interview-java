package com.java.interview.other.java8new.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 举个例子说明Lambda表达式可以作为参数传递给其他函数
 * Lambda表达式(name1, name2) -> name1.compareTo(name2)表示对列表中的元素进行比较。compareTo()方法返回一个整数值，用于指示两个字符串的大小关系，从而实现排序。
 *
 * 使用Lambda表达式作为参数传递给其他函数，使得我们不再需要编写额外的比较器类或匿名内部类来进行排序。
 * 这种方式大大简化了代码，并且更加直观，使得排序逻辑直接写在调用处，使代码更加紧凑和易于理解。
 * @author liaowenhui
 * @date 2023/7/28 15:30
 */
public class LambdaAsParameterExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Charlie");
        names.add("David");
        names.add("Bob");

        // 使用Lambda表达式作为参数传递给Collections.sort()方法
        Collections.sort(names, (name1, name2) -> name1.compareTo(name2));

        // 打印排序后的列表
        System.out.println("Sorted Names: " + names);
    }
}
