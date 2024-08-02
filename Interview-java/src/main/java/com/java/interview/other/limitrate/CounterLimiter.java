package com.java.interview.other.limitrate;/**
 * @author liaowenhui
 * @date 2023/3/14 15:43
 */

import lombok.Synchronized;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  计数器(固定窗口)算法
 * @author liaowenhui
 * @date 2023/3/14 15:43
 */
public class CounterLimiter {
    /**
     * 窗口大小，毫秒为单位
     */
    private int windowSize;
    /**
     * 窗口内限流大小
     */
    private int limit;
    /**
     * 当前窗口的计数器
     */
    private volatile AtomicInteger count;

    public CounterLimiter(int windowSize,int limit){
        this.limit = limit;
        this.windowSize = windowSize;
        count = new AtomicInteger(0);

        //方法1
        // 创建一个单线程的ScheduledExecutorService
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        // 创建一个Runnable任务
        Runnable task = () -> count.set(0);
        // 使用scheduleAtFixedRate方法安排任务，第一次执行延迟0秒，之后每隔windowSize毫秒执行一次
        executor.scheduleAtFixedRate(task, 0, windowSize, TimeUnit.MILLISECONDS);

        //方法2
        //开启一个线程，达到窗口结束时清空count
        /*new Thread(() -> {
            while(true){
                count.set(0);
                try {
                    Thread.sleep(windowSize);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
    }


    /**
     * 可以将tryAcquire（）方法改为同步方法，以避免多线程访问计数器时可能会出现的并发问题。
     * 请求到达后先调用本方法，若返回true，则请求通过，否则限流
     * @return
     */
    public synchronized boolean tryAcquire(){
        int newCount = count.addAndGet(1);
        if(newCount > limit){
            return false;
        }else{
            return true;
        }
    }

    //测试
    public static void main(String[] args) throws InterruptedException {
        //每秒20个请求
        CounterLimiter counterLimiter = new CounterLimiter(1000,20);
        int count = 0;
        //模拟50次请求，看多少能通过
        for(int i = 0;i < 50;i ++){
            if(counterLimiter.tryAcquire()){
                count ++;
            }
        }
        System.out.println("第一拨50次请求中通过：" + count + ",限流：" + (50 - count));
        //过一秒再请求
        Thread.sleep(1000);
        //模拟50次请求，看多少能通过
        count = 0;
        for(int i = 0;i < 50;i ++){
            if(counterLimiter.tryAcquire()){
                count ++;
            }
        }
        System.out.println("第二拨50次请求中通过：" + count + ",限流：" + (50 - count));
    }
}
