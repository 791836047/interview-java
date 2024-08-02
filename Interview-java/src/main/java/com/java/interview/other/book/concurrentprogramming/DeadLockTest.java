package com.java.interview.other.book.concurrentprogramming;

/**
 * 线程死锁 Page47 Page50 一起
 * @author liaowenhui
 * @date 2022/2/16 11:18
 */
public class DeadLockTest {
    public static Object resourceA = new Object();
    public static Object resourceB = new Object();

    public static void main(String[] args) {

        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }
            }
        });

        //创建线程B
        /*Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread() + "get ResourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resourceA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread() + "get resourceA");
                    }
                }

            }
        });*/

        //什么是资源申请的有序性呢？我们对上面线程B的代码进行如下修改
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get ResourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }

            }
        });


        threadA.start();
        threadB.start();
    }

}
