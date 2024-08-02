package com.java.interview.other.book.concurrentprogramming;

/**
 *  Page44
 *  调用 interrupted （） 方法后中断标志被清除了
 * @author liaowenhui
 * @date 2022/2/15 11:09
 */
public class InterruptedTest4 {

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志位true时会退出循环,并且清除中断标志
                while (!Thread.currentThread().interrupted()) {

                }
                System.out.println("ThreadOne is interrupted :"+Thread.currentThread().isInterrupted());
            }
        });

        //启动线程
        threadOne.start();

        //设置中断标志
        threadOne.interrupt();

        threadOne.join();
        System.out.println("main thread is over");
    }

}
