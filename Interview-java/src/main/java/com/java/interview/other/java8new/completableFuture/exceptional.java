package com.java.interview.other.java8new.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <<实战Java高并发程序设计>> page320
 * 如果没有异常发生则CompletableFuture 就会返回原有的结果。
 * 如果遇到了异常，就可以在exceptionally0方法中处理异常，并返回一个默认的值。
 *
 * @author liaowenhui
 * @date 2024/1/12 16:12
 */
public class exceptional {

    public static Integer calc(Integer para) {
        return para / 0;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc(50))
                .exceptionally(ex -> {
                    System.out.println(ex.toString());
                    return 0;
                }).thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "" + str + "\"").thenAccept(System.out::println);
        fu.get();
    }
}
