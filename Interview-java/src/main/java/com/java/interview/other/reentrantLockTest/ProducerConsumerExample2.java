package com.java.interview.other.reentrantLockTest;

/**
 * ProducerConsumerExample用synchronized来实现
 *
 * @author liaowenhui
 * @date 2023/7/21 10:18
 */
public class ProducerConsumerExample2 {
    private static final int BUFFER_SIZE = 5;
    private final Object producerLock = new Object();
    private final Object consumerLock = new Object();
    private final int[] buffer = new int[BUFFER_SIZE];
    private int count = 0; // 缓冲区中的元素数量

    public void produce(int value) throws InterruptedException {
        synchronized (producerLock) {
            while (count == BUFFER_SIZE) {
                // 缓冲区已满，等待
                producerLock.wait();
            }

            // 生产数据并放入缓冲区
            buffer[count] = value;
            count++;
            System.out.println("Produced: " + value);

            // 通知消费者缓冲区不为空
            synchronized (consumerLock) {
                consumerLock.notify();
            }
        }
    }

    public int consume() throws InterruptedException {
        synchronized (consumerLock) {
            while (count == 0) {
                // 缓冲区为空，等待
                consumerLock.wait();
            }

            // 从缓冲区取出数据并消费
            int value = buffer[count - 1];
            count--;
            System.out.println("Consumed: " + value);

            // 通知生产者缓冲区不满
            synchronized (producerLock) {
                producerLock.notify();
            }

            return value;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample2 example = new ProducerConsumerExample2();

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
