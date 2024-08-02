package com.java.interview.common;

/**
 * @author liaowenhui
 * @date 2021/12/28 11:01
 */
public class RandomUtil {
    public static final int SIZE = 10;

    public static void randomSort() {
        int[] datas = new int[SIZE];
        int i;
        //初始化数组值
        for (i = 0; i < SIZE; i++) {
            //Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
            datas[i] = (int) (100 + Math.random() * (100 + 1));
        }

        System.out.print("排序前的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(datas[i] + " ");
        }

        System.out.print("\n");

        //TODO 怎么根据反射调用对面的
        //冒泡排序
        //bubbleSort(datas);

        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(datas[i] + " ");
        }
    }

}
