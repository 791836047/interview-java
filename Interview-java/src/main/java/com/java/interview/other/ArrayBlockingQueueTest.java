package com.java.interview.other;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liaowenhui
 * @date 2023/12/26 10:51
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (!queue.isEmpty()) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer1.start();
        producer2.start();
        consumer.start();
    }
}
