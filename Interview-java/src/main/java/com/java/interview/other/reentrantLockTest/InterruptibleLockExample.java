package com.java.interview.other.reentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 理解ReenTrantLock的等待可中断：正在等待的线程可以选择放弃等待，改为处理其他事情
 * @author liaowenhui
 * @date 2023/12/25 10:08
 */
public class InterruptibleLockExample {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                lock.lockInterruptibly(); // 等待可中断地获取锁
                System.out.println("Thread 1 acquired the lock.");
                Thread.sleep(5000); // 模拟线程持有锁的操作，这里暂停5秒钟
                System.out.println("Thread 1 released the lock.");
                lock.unlock(); // 释放锁
            } catch (InterruptedException e) {
                System.out.println("Thread 1 was interrupted while waiting for the lock.");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                // 让thread2稍等一会儿，确保thread1先开始获取锁
                Thread.sleep(1000);
                // 尝试获取锁，但可以被中断
                lock.lockInterruptibly();
                System.out.println("Thread 2 acquired the lock.");
                lock.unlock(); // 释放锁
                System.out.println("Thread 2 released the lock.");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 was interrupted while waiting for the lock.");
            }
        });

        thread1.start();
        thread2.start();

        // 让线程运行一段时间后，尝试中断thread2
        try {
            Thread.sleep(2000);
            thread2.interrupt(); // 中断thread2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
