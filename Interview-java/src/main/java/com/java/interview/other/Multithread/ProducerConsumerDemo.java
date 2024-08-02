package com.java.interview.other.Multithread;/**
 * @author liaowenhui
 * @date 2023/3/20 17:24
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  来自必应
 *  eentrantLock对象可以同时绑定多个Condition对象的好处是，它可以让不同的线程等待不同的条件，
 *  从而实现更细粒度的控制。例如，在生产者消费者问题中，我们可以使用两个Condition对象来分别表示缓冲区是否为空和是否为满。
 *  这样，生产者线程只需要在缓冲区满时等待空缓冲区的条件，而消费者线程只需要在缓冲区空时等待非空缓冲区的条件。这样可以避免不必要的唤醒和竞争。
 * @author liaowenhui
 * @date 2023/3/20 17:24
 */
public class ProducerConsumerDemo {

    // 缓冲区大小
    private static final int BUFFER_SIZE = 10;

    // 缓冲区数组
    private static int[] buffer = new int[BUFFER_SIZE];

    // 缓冲区中元素的个数
    private static int count = 0;

    // 缓冲区中下一个可写入或可读取的位置
    private static int in = 0;
    private static int out = 0;

    // 可重入锁
    private static Lock lock = new ReentrantLock();

    // 空缓冲区条件
    private static Condition notEmpty = lock.newCondition();

    // 满缓冲区条件
    private static Condition notFull = lock.newCondition();

    // 生产者线程类
    public static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock(); // 获取锁

                    while (count == BUFFER_SIZE) { // 如果缓冲区满了，等待空缓冲区条件成立
                        notFull.await();
                    }

                    buffer[in] = 1; // 向缓冲区中写入数据（简化为1）
                    in = (in + 1) % BUFFER_SIZE; // 更新下一个可写入位置
                    count++; // 更新元素个数

                    System.out.println(Thread.currentThread().getName() + " produced 1 item. Buffer size: " + count);

                    notEmpty.signal(); // 唤醒等待非空缓冲区条件的线程

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock(); // 释放锁
                }
            }
        }
    }

    // 消费者线程类
    public static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock(); // 获取锁

                    while (count == 0) { // 如果缓冲区空了，等待非空缓冲区条件成立
                        notEmpty.await();
                    }

                    int data = buffer[out]; // 从缓冲区中读取数据（简化为1）
                    out = (out + 1) % BUFFER_SIZE; // 更新下一个可读取位置
                    count--; // 更新元素个数

                    System.out.println(Thread.currentThread().getName() + " consumed 1 item. Buffer size: " + count);

                    notFull.signal(); // 唤醒等待非满缓冲区条件的线程

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock(); // 释放锁
                }
            }
        }
    }

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Thread producerThread1 = new Thread(producer, "Producer-1");
        Thread producerThread2 = new Thread(producer, "Producer-2");
        Thread consumerThread1 = new Thread(consumer, "Consumer-1");
        Thread consumerThread2 = new Thread(consumer, "Consumer-2");

        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();

    }

}
