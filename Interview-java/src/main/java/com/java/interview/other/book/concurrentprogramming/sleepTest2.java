package com.java.interview.other.book.concurrentprogramming;

/**
 * 如果在睡眠期间其他线程调用了该线程的interrupt（）方法中断了该线程，则该线程会在调用sleep方法的地方抛出IntermptedException异常而返回。
 * Page 38
 * @author liaowenhui
 * @date 2022/2/14 18:25
 */
public class sleepTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child thread is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动子线程
        thread.start();

        //主线程休眠 2s
        Thread.sleep(2000);

        //主线程中断子线程
        thread.interrupt();
    }
}
