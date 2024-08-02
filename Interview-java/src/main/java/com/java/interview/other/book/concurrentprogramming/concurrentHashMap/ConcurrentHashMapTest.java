package com.java.interview.other.book.concurrentprogramming.concurrentHashMap;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Page316
 * @author liaowenhui
 * @date 2022/2/23 21:35
 */
public class ConcurrentHashMapTest {
    /**
     * (1)创建map,key为topic,value为设备列表
     */
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        //(2)进入直播间topic1 线程one
        Thread threadOne = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device1");
            list1.add("device2");

            map.put("topic1", list1);
            System.out.println(JSON.toJSONString(map));
        });

        /**
         * 进入直播间topic1 线程two
         */
        Thread threadTwo = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device11");
            list1.add("device22");

            map.put("topic1", list1);

            System.out.println(JSON.toJSONString(map));
        });

        /**
         * (4)进入直播间topic2 线程three
         */
        Thread threadThree = new Thread(new  Runnable() {
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device111");
                list1.add("device222");

                map.put("topic2", list1);

                System.out.println(JSON.toJSONString(map));
            }
        });

        //(5)启动线程
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
