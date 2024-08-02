package com.java.interview.other.book.concurrentprogramming.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Page271 CountDownLatch
 * @author liaowenhui
 * @date 2022/2/23 18:41
 */
public class JoinCountDownLatch {

    //因为两个子线程所以构造函数传参2
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("子线程1执行完毕");
                countDownLatch.countDown();
            }

            // 注意下边代码
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("不需要子线程执行完毕，只需要调用countdown后，主线程就可以继续执行");
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("子线程2执行完毕");
                    countDownLatch.countDown();
                }
            }
        });

        t2.start();
        t1.start();

        System.out.println("等待子线程执行完毕");
        countDownLatch.await();

        System.out.println("全都执行完毕");
    }

}
