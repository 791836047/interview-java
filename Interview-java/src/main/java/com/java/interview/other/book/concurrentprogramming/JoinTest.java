package com.java.interview.other.book.concurrentprogramming;

/**
 * 等待线程执行终止的join方法 Page32
 * @author liaowenhui
 * @date 2022/2/14 20:09
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over!");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo over!");
            }
        });

        //启动线程
        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        /**
         * 虽然主线程在等待 threadOne 执行完成后才会执行 threadTwo.join();，但这并不会影响 threadTwo 的实际执行顺序。
         * 主线程等待的顺序只是决定了主线程等待子线程执行完成的顺序，并不影响子线程的并发执行。
         * 所以，threadOne.join(); 和 threadTwo.join(); 决定了主线程等待子线程执行完毕的顺序，但不会直接影响子线程的执行顺序。
         * 因此，子线程 "child threadOne over!" 和 "child threadTwo over!" 的实际打印顺序仍然是不确定的，取决于线程调度和执行情况。
         *
         */
        //主线程让出执行权，等待子线程执行完毕,返回
        //注释再运行看看
        threadTwo.join();
        threadOne.join();

        System.out.println("all child thread over!");
    }
}
