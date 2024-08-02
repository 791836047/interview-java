package com.java.interview.other.HashSetTest;/**
 * @author liaowenhui
 * @date 2023/2/9 10:53
 */

import java.util.HashSet;

/**
 * 通过查看add方法的源码，我们知道这个方法底层依赖 两个方法：hashCode()和equals()。
 * 如果类没有重写这两个方法，默认使用的Object()。一般来说仅仅hashCode可能都不会相同，equals也不相同；则会全部添加到集合中去。
 *例如自定义对象没有重写hashCode()和equals()方法的时候，就全部打印出来。这也是不重复的原因。
 *而String类（写字符串对象的时候）重写了hashCode()和equals()方法，所以，它就可以把内容相同的字符串去掉。只留下一个
 * @author liaowenhui
 * @date 2023/2/9 10:53
 */
public class HashSetDemo {
    public static void main(String[] args) {
        // 创建集合对象
        HashSet<Student> hs = new HashSet<Student>();

        // 创建学生对象
        Student s1 = new Student("小明", 27);
        Student s2 = new Student("小红", 22);
        Student s3 = new Student("小绿", 30);
        Student s4 = new Student("小明", 27);
        Student s5 = new Student("小明", 20);
        Student s6 = new Student("小黄", 22);

        // 添加元素
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s5);
        hs.add(s6);

        // 遍历集合
        for (Student s : hs) {
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
