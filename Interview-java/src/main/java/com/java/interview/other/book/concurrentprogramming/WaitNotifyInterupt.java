package com.java.interview.other.book.concurrentprogramming;

/**
 * Page27
 * 当一个线程调用共享对象的wait（）方法被阻塞挂起后，如果其他线程中断了该线程，则该线程会抛出InterruptedException异常并返回
 * @author liaowenhui
 * @date 2022/2/14 13:51
 */
public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        System.out.println("-----begin-----------");
                        obj.wait();
                        System.out.println("-----end----------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread.sleep(1000);
        System.out.println("thread_Interrupt start...");
        thread.interrupt();
        System.out.println("thread_Interrupt end...");
    }
}
