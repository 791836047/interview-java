package com.java.interview.other.synchronizedtest;

/**
 * 对syncTest进行修改后
 * add()方法虽然也使用synchronized关键字修饰了，
 * 但是因为两次new syncTest()操作建立的是两个不同的对象，
 * 也就是说存在两个不同的对象锁，线程t1和t2使用的是不同的对象锁，所以不能保证线程安全。
 * @author liaowenhui
 */
public class SyncTest2 implements Runnable{
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

    /**
     * 读-修改-写冲突：多个线程同时读取变量 i 的值，然后对其进行递增操作，并最终写回结果。由于线程之间的操作是并发的，可能会发生读取-修改-写入冲突，导致某些递增操作被覆盖或丢失。
     */
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            add();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new SyncTest2());
        Thread t2 = new Thread(new SyncTest2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
