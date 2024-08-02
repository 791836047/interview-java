package com.java.interview.other.book.concurrentprogramming;

/**
 * Page26
 * 当线程调用共享对象的wait（）方法时，当前线程只会释放当前共享对象，当前线程持有的其他共享对象的监视器锁并不会被释放
 * @author liaowenhui
 * @date 2022/2/14 13:44
 */
public class WaitNotifyTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                        synchronized (resourceB) {
                            System.out.println("threadA get resourcesB lock");
                            System.out.println("threadA release resourceA lock");

                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //延迟一秒
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock ...");

                        synchronized (resourceB) {
                            System.out.println("threadB get resourcesB lock");
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");

    }
}
