package com.java.interview.other.book.concurrentprogramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式--使用FutureTask方式 Page21
 *
 * @author JustJavaIt
 */
public class FutureTasktest {
    public static void main(String[] args) {
        CallerTask callerTask = new CallerTask();
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(callerTask);
        //启动线程
        new Thread(futureTask).start();
        String result;
        try {
            //等待任务执行完毕，并返回结果。
            result = futureTask.get();
            System.out.println("result:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建任务类，类似Runable
     */
    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }
}
