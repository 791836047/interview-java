package com.java.interview.other.book.concurrentprogramming;

/**
 * page334
 * @author liaowenhui
 * @date 2022/2/24 11:37
 */
public class TestThreadName {
    public static void main(String[] args) {
        //订单模块
        Thread threadOne = new Thread(() -> {
            System.out.println("保存订单的线程");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new NullPointerException();
        });

        //发货模块
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                System.out.println("保存收获地址的线程");
            }
        });

        threadOne.start();
        threadTwo.start();

    }
}
