package com.java.interview.other;

import org.springframework.transaction.annotation.Transactional;

/**
 * 同一个类中方法调用导致事务失效
 * @author JustJavaIt
 * @date 2023/6/15 16:11
 */
public class ExampleServiceImpl {


    /**
     * 同一个类中方法调用，导致methodB()的@Transactional失效，不管methodA()上有没有声明注解事务
     * 如果方法B的操作一成功，操作二抛异常，那么操作一不会回滚
     * 解决方法：把methodB()放入新增的一个ServiceB中，注入ServiceB，通过ServiceB.methodB()的方式即可
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void methodA() {
        this.methodB();
    }

    @Transactional(rollbackFor = Exception.class)
    public void methodB() {
        //操作一：更新表A信息

        //操作二：更新表B信息
    }
}
