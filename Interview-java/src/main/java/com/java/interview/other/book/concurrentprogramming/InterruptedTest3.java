package com.java.interview.other.book.concurrentprogramming;

/**
 *  Page43
 *  了解interrupt()和isInterrupted()的不同之处
 * @author liaowenhui
 * @date 2022/2/15 11:09
 */
public class InterruptedTest3 {

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                }
            }
        });

        //启动线程
        threadOne.start();

        //设置中断标志
        threadOne.interrupt();

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        /**
         * 在 interrupted()方法内部是获取当前线程的中断状态，这里虽然
         * 调用了 threadOne.interrupted()，但是获取的是主线程的中断标志，因为主线程是当前线程。
         */
        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadOne.interrupted());

        //获取中断标志并重置
        System.out.println("isInterrupted:" + Thread.interrupted());

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main is over");
    }

}
