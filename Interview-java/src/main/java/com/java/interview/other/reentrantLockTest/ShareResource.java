package com.java.interview.other.reentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  ReentrantLock绑定多个Condition（代码实现）
 * 多线程按顺序调用 , A->B->C  A打印5次，B打印10次，C打印15次
 * 在 synchronized 中，锁对象使用Object的 wait() 和 notify() 或 notifyAll() 等方法实现线程间的通信和同步。
 * 而ReentrantLock相应的提供了Condition的await()、signal()、singalAll()方法作为替代。
 * @author liaowenhui
 * @date 2022/4/12 9:56
 */
public class ShareResource {

    public static void main(String args[]){
        final ShareResource test = new ShareResource();
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i =0 ; i < 10; i++)
                {
                    test.prints5();
                }
            }
        },"A").start();;

        new Thread(() -> {
            for(int i =0 ; i < 10; i++)
            {
                test.prints10();
            }
        },"B").start();

        new Thread(() -> {
            for(int i =0 ; i < 10; i++)
            {
                test.prints15();
            }
        },"C").start();
    }

    private int number = 1;
    //A :1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 =lock.newCondition();
    private Condition c2 =lock.newCondition();
    private Condition c3 =lock.newCondition();
    public void prints5(){
        lock.lock();
        try
        {
            while(number!=1)
            {
                c1.await();
            }
            for(int i = 0; i < 5; i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number =2;
            c2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void prints10(){
        lock.lock();
        try
        {
            while(number!=2)
            {
                c2.await();
            }
            for(int i = 0; i < 10; i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number =3;
            c3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void prints15(){
        lock.lock();
        try
        {
            while(number!=3)
            {
                c3.await();
            }
            for(int i = 0; i < 15; i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number =1;
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
