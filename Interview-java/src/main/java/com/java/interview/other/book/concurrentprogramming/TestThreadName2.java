package com.java.interview.other.book.concurrentprogramming;

/**
 * page336
 * @author liaowenhui
 * @date 2022/2/24 11:37
 */
public class TestThreadName2 {
        static final String THREAD_SAVE_ORDER = "THREAD_SAVE_ORDER";
        static final String THREAD_SAVE_ADDR = "THREAD_SAVE_ADDR";

        public static void main(String[] args) {
            // 订单模块
            Thread threadOne = new Thread(() -> {
                System.out.println("保存订单的线程");
                throw new NullPointerException();
            }, THREAD_SAVE_ORDER);
            // 发货模块
            Thread threadTwo = new Thread(new Runnable() {
                public void run() {
                    System.out.println("保存收货地址的线程");
                }
            }, THREAD_SAVE_ADDR);

            threadOne.start();
            threadTwo.start();

        }
}
