package com.java.interview.other.book.concurrentprogramming.cycleBarrierTest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page281
 * 假设一个任务由阶段1、阶段2和阶段3组成，每个线程要串行地执行阶段1、阶段2和阶段3，当多个线程执行该任务时，
 * 必须要保证所有线程的阶段1全部完成后才能进入阶段2执行，当所有线程的阶段2全部完成后才能进入阶段3执行。下面使用 CyclicBarrier 来完成这个需求。
 */
public class CycleBarrierTest2 {
    //创建一个线程数固定为2的线程池
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //添加线程A到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "step1");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "step2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "step3");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //添加线程B到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "step1");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "step2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "step3");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //关闭线程池
        executorService.shutdown();

    }
}
