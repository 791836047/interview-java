package com.java.interview.other.book.concurrentprogramming.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Page287
 * 在主线程中开启两个子线程让它们执行，等所有子线程执行完毕后主线程再继续向下运行。
 *
 * @author liaowenhui
 * @date 2023/12/26 9:32
 */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        semaphore.acquire(2);
        System.out.println("all child thread over!");
        executorService.shutdown();

    }
}
