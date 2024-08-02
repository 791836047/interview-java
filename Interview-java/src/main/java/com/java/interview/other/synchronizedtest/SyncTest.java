package com.java.interview.other.synchronizedtest;

/**
 * Synchronized关键字修饰非静态(实例)方法
 * @author JustJavaIt
 */
public class SyncTest implements Runnable{

    /**
     * 共享资源
     */
    private static int i = 0;

    /**
     * 修饰非静态(实例)方法时,是取调用该方法的对象实例作为线程要持有的锁。
     */
    private synchronized void add() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            add();
        }
    }

    public static void main(String[] args) throws Exception {
        SyncTest syncTest = new SyncTest();
        Thread t1 = new Thread(syncTest);
        Thread t2 = new Thread(syncTest);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
