package com.java.interview.other.java8new.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture指定的线程池来执行异步任务。
 * @author liaowenhui
 * @date 2023/7/28 14:18
 */
public class CompletableFutureCustomThreadPoolExample {

    public static void main(String[] args) {
        // 创建一个自定义线程池，使用固定大小的线程池
        ExecutorService customThreadPool = Executors.newFixedThreadPool(4);

        /**
         * supplyAsync()
         * 返回一个新的CompletableFuture，该CompletableFuture将由在给定执行器中运行的任务异步完成，
         * 该任务的值是通过调用给定的Supplier获得的。
         *
         * 如果你创建一个 CompletableFuture 而没有指定线程池，它会使用默认的 ForkJoinPool 实例来执行任务。
         */
        // 异步执行任务，并指定自定义线程池
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务在线程: " + Thread.currentThread().getName());
            return "成功";
        }, customThreadPool);

        // 使用get()方法等待任务完成并获取结果
        try {
            String result = future.get();
            System.out.println("任务执行完成，结果为: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭自定义线程池
        customThreadPool.shutdown();
    }
}
