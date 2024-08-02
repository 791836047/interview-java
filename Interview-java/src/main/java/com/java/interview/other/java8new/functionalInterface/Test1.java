package com.java.interview.other.java8new.functionalInterface;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。函数式接口可以被隐式转换为 lambda 表达式
 * @author liaowenhui
 * @date 2022/1/12 10:44
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            int finalI = i;
            //匿名类实现Runnable接口
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
            //lambda表达式的方式，Runnable是函数式接口可以被隐式转换为 lambda 表达式
           /* executor.execute(() -> {
                System.out.println("正在执行task " + finalI);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task " + finalI + "执行完毕");
            });*/
            System.out.println("线程池中线程数目：" + executor.getPoolSize() +
                    "，队列中等待执行的任务数目：" + executor.getQueue().size() +
                    "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}

