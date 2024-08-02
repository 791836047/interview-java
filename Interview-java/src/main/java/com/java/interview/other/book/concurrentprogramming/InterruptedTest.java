package com.java.interview.other.book.concurrentprogramming;

/**
 * page42
 * 看一个线程使用 Int rrupted 优雅退出的经典例子
 * @author liaowenhui
 * @date 2022/2/15 11:05
 */
public class InterruptedTest {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "hello");
                }

            }
        });
        //启动子线程
        thread.start();

        //主线程休眠1s，以便中断前让子线程输出
        Thread.sleep(1000);

        //中断子线程
        System.out.println("main thread interrupted thread");
        thread.interrupt();

        //等待子线程执行完毕
        thread.join();
        System.out.println("main is over");
    }
}
