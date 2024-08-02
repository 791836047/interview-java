package com.java.interview.other.limitrate;/**
 * @author liaowenhui
 * @date 2023/3/14 17:08
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 优化后
 * 使用ScheduledExecutorService类来定时清空计数器，而不是自己创建一个新线程。这样可以避免线程管理的复杂性和开销。
 * 使用Semaphore类来实现限流逻辑，而不是自己维护一个计数器和一个限流大小。这样可以简化代码，并利用Semaphore类提供的同步和公平性特性。
 * 使用System.nanoTime()方法来获取当前时间，而不是System.currentTimeMillis()方法。这样可以提高时间精度，并避免时钟漂移的影响。
 *
 * @author liaowenhui
 * @date 2023/3/14 17:08
 */
public class CounterLimiter2 {
    // 窗口大小，纳秒为单位
    private long windowSize;
    // 信号量，用于限流
    private Semaphore semaphore;
    // 定时任务执行器，用于清空信号量
    private ScheduledExecutorService scheduler;

    public CounterLimiter2(int windowSize, int limit) {
        this.windowSize = TimeUnit.MILLISECONDS.toNanos(windowSize);
        this.semaphore = new Semaphore(limit);
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        // 开启一个定时任务，在每个窗口结束时清空信号量
        this.scheduler.scheduleAtFixedRate(() -> semaphore.drainPermits(), this.windowSize, this.windowSize, TimeUnit.NANOSECONDS);
    }

    // 请求到达后先调用本方法，若返回true，则请求通过，否则限流
    public boolean tryAcquire() {
        return semaphore.tryAcquire();
    }

    // 测试
    public static void main(String[] args) throws InterruptedException {
        // 每秒20个请求
        CounterLimiter counterLimiter = new CounterLimiter(1000, 20);
        int count = 0;
        // 模拟50次请求，看多少能通过
        for (int i = 0; i < 50; i++) {
            if (counterLimiter.tryAcquire()) {
                count++;
            }
        }
        System.out.println("第一拨50次请求中通过：" + count + "，限流：" + (50 - count));

        // 过一秒再请求
        Thread.sleep(1000);

        // 模拟50次请求，看多少能通过
        count = 0;
        for (int i = 0; i < 50; i++) {
            if (counterLimiter.tryAcquire()) {
                count++;
            }
        }
        System.out.println("第二拨50次请求中通过：" + count + "，限流：" + (50 - count));

    }
}
