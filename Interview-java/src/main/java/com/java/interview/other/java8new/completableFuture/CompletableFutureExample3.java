package com.java.interview.other.java8new.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 将多个 CompletableFuture 进行组合。另外一种组合多个CompletableFuture 的方法是thenCombine()
 * @author liaowenhui
 * @date 2024/1/12 16:24
 */
public class CompletableFutureExample3 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + result2);

        System.out.println("Result: " + combinedFuture.join());
    }
}
