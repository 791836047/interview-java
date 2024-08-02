package com.java.interview.other.book.concurrentprogramming;

/**
 * 创建线程方式--继承Thread类的方式的实现
 *
 * @author JustJavaIt
 * @date 2022/2/12 15:48
 */
public class ThreadTest {

    public static void main(String[] args) {
        //创建线程
        MyThread thread = new MyThread();
        //启动线程
        thread.start();
        System.out.println("I am main thread");

    }

    /**
     * 继承Thread类，并重写run方法
     * 不好的地方是java不支持多继承，如果继承了Thread类，就不能再继承其他类，另外任务和代码没有分离，当多个线程执行一样的任务的时需要多份代码。
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

}
