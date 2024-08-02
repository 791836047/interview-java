package com.java.interview.other.book.concurrentprogramming;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Page129
 * CopyOnWriteArrayList提供了弱一致性的迭代器（弱一致性是指返回迭代器后，其他线程对list的增删改对迭代器是不可见的），从而保证在获取迭代器后，
 * 其他线程对list的修改是不可见的，迭代器遍历的数组是一个快照。
 * @author liaowenhui
 * @date 2022/2/22 18:38
 */
public class Copylist {
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
    public static void main( String[] args ) throws InterruptedException{
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //修改list中下标为1的元素为baba
                arrayList.set(1, "baba");
                //删除元素
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });
        //保证在修改线程启动前获取迭代器
        Iterator<String> itr = arrayList.iterator();
        //启动线程
        threadOne.start();
        //等待子线程执行完毕
        threadOne.join();
        //迭代元素
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
