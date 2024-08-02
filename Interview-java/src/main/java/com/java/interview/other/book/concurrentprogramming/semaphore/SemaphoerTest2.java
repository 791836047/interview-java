package com.java.interview.other.book.concurrentprogramming.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Page289
 * 模拟CycliBarrier复用的功能
 * <p>
 * 代码首先将线程 A 和线程 B 加入到线程池。主线程执行代码 (1)后被阻塞。线程A和线程 B 调用release 方法后信号量的值变为了2，
 * 这时候主线程的 aquire 方法会在获取到2个信号量后返回(返回后当前信号量值为 0)。
 * 然后主线程添加线程C 和线程D到线程池，之后主线程执行代码(2) 后被阻塞 (因为主线程要获取 2 个信号量，而当前信号量个数为0)。
 * 当线程C和线程 D 执行完release 方法后，主线程才返回。从本例子可以看出，Semaphore 在某种程度上实现了 CyclicBarrier 的复用功能。
 *
 * @author liaowenhui
 * @date 2023/12/26 9:35
 */
public class SemaphoerTest2 {
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "A task over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //将线程B 添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "A task over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // (1)等待子线程执行任务A完毕，返回
        semaphore.acquire(2);
        System.out.println("task A is over");

        //将线程C添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "B task over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //将线程D添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "B task over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //(2)等待子线程执行B究毕，返回
        semaphore.acquire(2);
        System.out.println("task B is over");

        executorService.shutdown();
    }
}
