package com.java.interview.other.java8new.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 将多个 CompletableFuture 进行组合。一种方法是使用thenCompose方法
 *
 * chatgpt: 可以举个例子突显CompletableFuture比起使用线程池异步任务的管理和组合更加简单和直观
 * 当涉及多个异步任务的依赖和组合时，CompletableFuture相比使用普通线程池来说，确实可以更加简单和直观。让我们来看一个实际的例子来突显这一点。
 *
 * 假设我们需要实现一个简单的异步任务处理流程：
 * 首先，从远程服务器获取用户信息；
 * 接着，根据用户信息获取对应的订单信息；
 * 最后，根据订单信息获取相应的支付信息。
 * 这个异步任务的处理流程包含了多个依赖的任务，使用CompletableFuture可以轻松实现它们的组合。
 * @author liaowenhui
 * @date 2023/7/28 14:40
 */
public class CompletableFutureExample2 {

    // 模拟从远程服务器获取用户信息的异步任务
    private static CompletableFuture<String> fetchUserInfo() {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟从远程服务器获取用户信息的耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "User Info";
        });
    }

    // 模拟根据用户信息获取订单信息的异步任务
    private static CompletableFuture<String> fetchOrderInfo(String userInfo) {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟根据用户信息获取订单信息的耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Order Info for " + userInfo;
        });
    }

    // 模拟根据订单信息获取支付信息的异步任务
    private static CompletableFuture<String> fetchPaymentInfo(String orderInfo) {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟根据订单信息获取支付信息的耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Payment Info for " + orderInfo;
        });
    }

    public static void main(String[] args) {
        // 使用CompletableFuture组合异步任务
        CompletableFuture<String> future = fetchUserInfo()
                .thenCompose(userInfo -> fetchOrderInfo(userInfo))
                .thenCompose(orderInfo -> fetchPaymentInfo(orderInfo));

        // 使用get()方法等待任务完成并获取结果
        try {
            String result = future.get();
            System.out.println("任务执行完成，结果为: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
