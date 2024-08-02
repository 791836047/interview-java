package com.java.interview.other.synchronizedtest;

/**
 * @author liaowenhui
 * @date 2022/2/19 18:22
 */
public class SyncTest4 implements Runnable {
        /**
         * 共享资源
         */
        static int i = 0;
        @Override
        public void run() {
            //其他操作.......
            /**
             * this表示当前对象实例(调用方法的对象实例)，等价于synchronized修饰非静态方法
             * 这里还可以使用syncTest4.class，表示class对象锁，等价于synchronized修饰静态方法
             */
            synchronized (this){
                for (int j = 0; j < 10000; j++) {
                    i++;
                }
            }
        }
        public static void main(String[] args) throws Exception {
            //SyncTest4 syncTest = new SyncTest4();
            Thread t1 = new Thread(new SyncTest4());
            Thread t2 = new Thread(new SyncTest4());
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(i);
        }
    }

