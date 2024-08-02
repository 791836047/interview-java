package com.java.interview.other.book.concurrentprogramming.threadlocal;

/**
 * 采用 ThreadLocal 的方式
 * @author justJavaIt
 * @date 2022/6/18 15:10
 */
public class MyThreadLocalDemo {
    private static ThreadLocal<String> tl = new ThreadLocal<>();

    private String content;

    private String getContent() {
        return tl.get();
    }

    private void setContent(String content) {
        tl.set(content);
    }

    public static void main(String[] args) {
        MyThreadLocalDemo demo = new MyThreadLocalDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-----------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}

