package com.java.interview.other.reentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 理解ReentrantLock绑定多个Condition
 * @author liaowenhui
 * @date 2023/7/21 10:06
 */
public class ProducerConsumerExample {
    private static final int BUFFER_SIZE = 5;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition(); // 缓冲区不满的条件
    private final Condition notEmpty = lock.newCondition(); // 缓冲区不空的条件
    private final int[] buffer = new int[BUFFER_SIZE];
    private int count = 0; // 缓冲区中的元素数量

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (count == BUFFER_SIZE) {
                // 缓冲区已满，等待缓冲区不满的条件
                notFull.await();
            }

            // 生产数据并放入缓冲区
            buffer[count] = value;
            count++;
            System.out.println("Produced: " + value);

            // 通知消费者缓冲区不为空
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                // 缓冲区为空，等待缓冲区不空的条件
                notEmpty.await();
            }

            // 从缓冲区取出数据并消费
            int value = buffer[count - 1];
            count--;
            System.out.println("Consumed: " + value);

            // 通知生产者缓冲区不满
            notFull.signal();

            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        // 创建并启动生产者线程
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    example.produce(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 创建并启动消费者线程
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    example.consume();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }

}
