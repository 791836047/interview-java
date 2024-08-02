package com.java.interview.other.book.concurrentprogramming.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * page106
 * 多线程使用AtomicLong 统计0的个数。
 *
 * @author liaowenhui
 * @date 2022/2/21 17:49
 */
public class Atomic {
    //创建数据源
    private static Integer[] arr1 = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arr2 = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    /**
     * 创建Long型原之类计数器
     */
    private static AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {

        //线程一统计数组arr1中0的个数
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });

        //线程二统计数组arr2中0的个数
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    if (arr2[i] == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        //启动子线程
        threadOne.start();
        threadTwo.start();
        //等待线程执行完毕
        threadOne.join();
        threadTwo.join();
        System.out.println("两个数组中共有" + atomicLong.get() + "个0");
    }
}
