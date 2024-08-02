package com.java.interview.other.Multithread;


import com.java.interview.other.MyTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * @author liaowenhui
 * @date 2022/1/6 10:41
 */
public class Multithreading {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() +
                    "，队列中等待执行的任务数目：" + executor.getQueue().size() +
                    "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        //写法2
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            //execute里面匿名类的方式可用lamda表达式再简化() -> {}
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("正在执行task " + finalI);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task " + finalI + "执行完毕");
                }
            });
            System.out.println("线程池中线程数目：" + executor.getPoolSize() +
                    "，队列中等待执行的任务数目：" + executor.getQueue().size() +
                    "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}
