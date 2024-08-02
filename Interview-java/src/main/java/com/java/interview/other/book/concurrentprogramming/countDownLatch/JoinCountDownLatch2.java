package com.java.interview.other.book.concurrentprogramming.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page273 CountDownLatch2
 * @author liaowenhui
 * @date 2022/2/23 18:41
 */
public class JoinCountDownLatch2 {

    //因为两个子线程所以构造函数传参2
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("子线程1执行完毕");
                countDownLatch.countDown();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当子线程调用countdown之后，主线程await方法就会方法（只要计数器为0）");
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("子线程2执行完毕");
                countDownLatch.countDown();
            }
        });

        System.out.println("等待子线程执行");
        countDownLatch.await();

        System.out.println("全都执行完毕");
        //这个方法需要调用，如果不调用的话，主线程会一直运行，因为线程池并未结束（用户线程）
        executorService.shutdown();
    }

}
