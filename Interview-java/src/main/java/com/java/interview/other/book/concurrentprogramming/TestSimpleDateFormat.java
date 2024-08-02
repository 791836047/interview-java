package com.java.interview.other.book.concurrentprogramming;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Page320
 * @author liaowenhui
 * @date 2022/2/24 11:20
 */
public class TestSimpleDateFormat {
    //(1)创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //(2)创建多个线程，并启动
        for (int i = 0; i <10 ; ++i) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        //(3)使用单例日期实例解析文本
                        System.out.println(sdf.parse("2018-07-12 15:18:00"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();//(4)启动线程
        }
    }
}
