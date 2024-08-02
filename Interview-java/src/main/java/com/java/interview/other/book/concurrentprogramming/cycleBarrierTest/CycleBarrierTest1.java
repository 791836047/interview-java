package com.java.interview.other.book.concurrentprogramming.cycleBarrierTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * page280
 *
 * @author liaowenhui
 * @date 2023/12/25 17:24
 */
public class CycleBarrierTest1 {

    // 创建一个CyclicBarrier实例,添加一个所有子线程全部到达屏障后执行的任务
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " taskl merge result");
        }
    });

    public static void main(String[] args) {

        //创建一个线程个数固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "taskl-l");
                    System.out.println(Thread.currentThread() + " enter in barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + " enter out barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        //将线程B添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "taskl-2");
                    System.out.println(Thread.currentThread() + "enter in barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "enter out barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 关闭线程池
        executorService.shutdown();

    }
}
