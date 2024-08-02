package com.java.interview.other.book.concurrentprogramming;

/**
 *  Page43
 * @author liaowenhui
 * @date 2022/2/15 11:09
 */
public class InterruptedTest2 {

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("ThreadOne begin sleep for 2000s");
                    Thread.sleep(20000);
                    System.out.println("ThreadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("ThreadOne is interrupted while sleeping");
                    return;
                }

                System.out.println("ThreadOne-leaving normally");
            }
        });

        //启动线程
        threadOne.start();

        //确保子线程进入休眠
        Thread.sleep(1000);

        //打断子线程的休眠，让子线程从sleep函数返回
        threadOne.interrupt();

        //等待子线程执行完毕
        threadOne.join();

        System.out.println("main thread is over");

    }

}
