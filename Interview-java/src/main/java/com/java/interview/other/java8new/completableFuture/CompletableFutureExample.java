package com.java.interview.other.java8new.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liaowenhui
 * @date 2023/7/28 14:13
 */
public class CompletableFutureExample {

    /**
     * 模拟从不同网站获取数据的异步方法
     * @param website
     * @return
     */
    private static CompletableFuture<String> fetchDataFromWebsite(String website) {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟获取数据的耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return website + " data";
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> dataFromBaidu = fetchDataFromWebsite("baidu");
        CompletableFuture<String> dataFromSohu = fetchDataFromWebsite("sohu");
        CompletableFuture<String> dataFromGoogle = fetchDataFromWebsite("google");

        // 使用allOf方法等待所有任务完成
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(dataFromBaidu, dataFromSohu, dataFromGoogle);

        // 在所有任务完成后，合并数据并返回结果
        CompletableFuture<String> combinedResult = allTasks.thenApply(v -> {
            try {
                String result1 = dataFromBaidu.get();
                String result2 = dataFromSohu.get();
                String result3 = dataFromGoogle.get();

                return result1 + "\n" + result2 + "\n" + result3;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            return "Error occurred while fetching data.";
        });

        // 等待合并后的结果并输出
        try {
            String finalResult = combinedResult.get();
            System.out.println("Combined Result:\n" + finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
