package com.java.interview.other.java8new.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liaowenhui
 * @date 2022/3/23 18:34
 */
public class CollectingAndThenTest {
    public static void main(String[] args) {
        //数据准备
        User user1 = new User(1, "hangman", 100);
        User user2 = new User(1, "list", 200);
        User user3 = new User(2, "wing", 200);
        User user4 = new User(2, "zeal", 100);
        User user5 = new User(3, "tuba", 300);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);


        //对集合的结果进行去重(UserId相同取salary小的)
        List<User> list = userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getUserId))), ArrayList::new));
        System.out.println("对集合的结果进行去重,UserId相同取salary小的:" + list);

        //对集合的结果进行去重(UserId相同取salary大的)
        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getSalary).reversed())
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getUserId))), ArrayList::new));
        System.out.println("UserId相同取salary大的:" + collect);

    /*    Map<Integer, User> collect = userList.stream().collect(
                Collectors.groupingBy(User::getUserId, Collectors.collectingAndThen(Collectors.reducing((a, b) ->
                                a.getSalary() > b.getSalary() ? a : b
                        ), Optional::get)
                ));*/

        System.out.println("collect:"+ collect);


        //查找工资最高的员工的姓名
        String userName = userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(User::getSalary)),(Optional<User> user) -> user.map(User::getUserName).orElse(null)));
        System.out.println("工资最高的员工的姓名:" + userName);

        //计算用户工资的平均值
        Double avgSalary = userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.averagingDouble(User::getSalary), Double::doubleValue));
        System.out.println("计算用户工资的平均值:" + avgSalary);

    }
}
