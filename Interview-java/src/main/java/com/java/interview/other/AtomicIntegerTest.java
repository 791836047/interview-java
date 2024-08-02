package com.java.interview.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liaowenhui
 * @date 2022/4/17 10:11
 */
public class AtomicIntegerTest {
    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                // 获取并且自增 i++
                i.getAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                // 获取并且自减 i--
                i.getAndDecrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
