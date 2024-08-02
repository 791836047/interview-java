package com.java.interview.other.book.concurrentprogramming;

import java.util.concurrent.locks.LockSupport;

/**
 * Page132
 * @author liaowenhui
 * @date 2022/2/23 15:07
 */
public class ParkUnparkTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

            System.out.println("child thread begin park!");
            // 调用park方法，挂起自己
            LockSupport.park();
            System.out.println("child thread unpark!");

        }
        });
        //启动子线程
        thread.start();
        //主线程休眠1S
        Thread.sleep(1000);

        //调用unpark让thread线程持有许可证，然后park方法会返回
        System.out.println("main thread begin unpark!");
        LockSupport.unpark(thread);

    }

}
