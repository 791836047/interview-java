package com.java.interview.other.book.concurrentprogramming;

/**
 * 创建线程方式--实现Runnable接口的run方法。
 *
 * @author JustJavaIt
 * @date 2022/2/12 16:21
 */
public class RunableTest {
    public static void main(String[] args) {
        RunableTask task = new RunableTask();
        //任务和代码分离，当多个线程执行一样任务时不用多份任务代码。
        new Thread(task).start();
        new Thread(task).start();
    }

    public static class RunableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }
}
