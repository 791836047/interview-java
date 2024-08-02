package com.java.interview.other.design.flyweightPattern.demo1;



import java.util.HashMap;
import java.util.Map;

/**
 * 亨元模式
 *
 * 假设我们有一个Student类，它包含学生的ID和姓名。我们希望在创建Student对象时，如果已经存在相同ID和姓名的对象，
 * 则返回缓存的对象，否则创建新的对象并将其缓存起来。我们可以使用一个静态工厂方法来实现这个功能：
 * @author liaowenhui
 * @date 2023/11/6 16:59
 */
public class StudentFactory {
    private static final Map<String, Student> cache = new HashMap<>();

    public static Student create(int id, String name) {
        String key = id + ":" + name;
        Student student = cache.get(key);
        if (student == null) {
            student = new Student(id, name);
            cache.put(key, student);
        }
        return student;
    }
}
