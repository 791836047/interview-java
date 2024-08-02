package com.java.interview.other.Multithread;

/**
 * @author liaowenhui
 * @date 2023/5/10 16:27
 */
public class TestTask implements Runnable {
    int retryCount = 0;
    @Override
    public void run() {
        try {
            // 模拟任务失败
            throw new RuntimeException("任务失败");
        } catch (Exception e) {
            if (++retryCount <= 3) {
                System.out.println("任务失败，正在重试第 " + retryCount + " 次");
            } else {
                System.out.println("任务失败，已达到最大重试次数");
            }
        }
    }
}
