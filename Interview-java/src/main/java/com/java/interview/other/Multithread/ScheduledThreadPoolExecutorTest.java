package com.java.interview.other.Multithread;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liaowenhui
 * @date 2023/5/10 16:26
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        TestTask task = new TestTask();
        executor.schedule(task, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000); // 等待足够的时间以便任务执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
