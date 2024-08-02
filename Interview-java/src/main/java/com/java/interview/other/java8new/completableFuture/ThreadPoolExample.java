package com.java.interview.other.java8new.completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CompletableFutureExample2如果使用普通线程池的示例：
 * 在上面的示例中，我们手动创建了一个线程池，并使用Future对象来管理任务的依赖和组合。
 * 需要注意的是，在使用普通线程池时，需要手动调用get()方法来获取上一个任务的结果，
 * 并将其传递给下一个任务。这样显得比较繁琐，而且容易出现Future.get()方法阻塞的情况。
 *
 * 可以看到，使用CompletableFuture的代码更加简洁、直观和易于理解，通过thenCompose()方法，我们将三个异步任务串联在一起，
 * 实现了任务的依赖和组合，而不需要手动处理Future对象。因此，CompletableFuture在处理多个依赖和组合的异步任务时，
 * 相比使用普通线程池，能够提供更加简单、直观和优雅的编程方式。
 * @author liaowenhui
 * @date 2023/7/28 14:54
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // 提交第一个任务，并获取用户信息
        Future<String> future1 = threadPool.submit(() -> {
            // 模拟从远程服务器获取用户信息的耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "User Info";
        });

        // 提交第二个任务，并根据用户信息获取订单信息
        Future<String> future2 = threadPool.submit(() -> {
            try {
                String userInfo = future1.get();
                // 模拟根据用户信息获取订单信息的耗时操作
                Thread.sleep(2000);
                return "Order Info for " + userInfo;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });

        // 提交第三个任务，并根据订单信息获取支付信息
        Future<String> future3 = threadPool.submit(() -> {
            try {
                String orderInfo = future2.get();
                // 模拟根据订单信息获取支付信息的耗时操作
                Thread.sleep(2000);
                return "Payment Info for " + orderInfo;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });

        // 等待所有任务完成并获取结果
        try {
            String result = future3.get();
            System.out.println("任务执行完成，结果为: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}
