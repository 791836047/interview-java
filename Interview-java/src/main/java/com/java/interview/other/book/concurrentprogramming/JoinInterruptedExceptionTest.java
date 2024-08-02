package com.java.interview.other.book.concurrentprogramming;

/**
 * page34
 * 线程A调用线程B的 join 方法后会被阻塞,当其他线程调用了线程A
 * intrrupt（）方法中断了线程A时，线程A会抛出 InterruptedException 异常而返回。
 * @author liaowenhui
 * @date 2022/2/14 20:17
 */
public class JoinInterruptedExceptionTest {
    public static void main(String[] args) throws InterruptedException {

        //线程 One
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run!");
                for (; ; ) {
                }
            }
        });

        //获取主线程
        final Thread mainThread = Thread.currentThread();

        //线程 two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //中断主线程
                mainThread.interrupt();
            }
        });

        //启动子线程
        threadOne.start();

        //延迟 1s 启动线程
        threadTwo.start();

        //主线程调用threadOne的join方法阻塞自己，等待线程 One 执行结束
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }

    }
}
