package com.java.interview.other.book.concurrentprogramming;

/**
 * page29
 * @author liaowenhui
 * @date 2022/2/14 19:50
 */
public class NotifyNotifyAllTest {
    //创建资源
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException{

        //创建线程 threadA
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                //获取 resourceA 的资源监视器
                synchronized (resourceA){
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //创建线程 threadB
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {

                //获取 resourceB 的资源监视器
                synchronized (resourceA){
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //创建线程 threadC
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    //resourceA.notify();
                    resourceA.notifyAll();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
        //确保让线程A、B都调用wait()方法后被阻塞后，让线程C再调用notify()方法
        Thread.sleep(1000);
        threadC.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");

    }
}
