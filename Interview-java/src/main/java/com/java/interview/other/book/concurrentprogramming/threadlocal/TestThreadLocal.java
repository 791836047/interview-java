package com.java.interview.other.book.concurrentprogramming.threadlocal;

/**
 * ThreadLocal不支持继承 Page62
 * @author liaowenhui
 * @date 2022/2/17 16:00
 */
public class TestThreadLocal  {

    // (1) 创建线程变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    //测试InheritableThreadLocal让子线程可以访问在父程序中设置的本地变量。
    //public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();


    public static void main(String[] args) {
        // (2) 设置线程变量
        threadLocal.set("hello world");
        // (3) 启动子线程
        Thread thread = new Thread(() -> {
            // (4) 子线程输出线程变量的值
            System.out.println("thread: " + threadLocal.get());
        });

        thread.start();
        // (5) 主线程获取并输出threadLocal的值
        System.out.println("main: " + threadLocal.get());
    }
}
