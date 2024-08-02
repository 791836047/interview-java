package com.java.interview.other.synchronizedtest;

/**
 * 在add()方法前用static修饰即可，即当synchronized作用于静态方法，锁就是当前的class对象。
 * @author JustJavaIt
 */
public class SyncTest3 implements Runnable {
    /**
     * 共享资源
     */
    private static int i = 0;

    private static synchronized void add() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            add();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new SyncTest3());
        Thread t2 = new Thread(new SyncTest3());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
