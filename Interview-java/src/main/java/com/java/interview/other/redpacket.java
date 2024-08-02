package com.java.interview.other;/**
 * @author liaowenhui
 * @date 2022/9/23 14:46
 */

import java.util.Arrays;
import java.util.Random;

/**
 * 字节一面场景题目
 *  假设当前还有n个人未领取，红包剩余金额为m元
 * 剩余的n个人按顺序领取，每个人可领取[1 ～（m - (n - 1))]区间的随机金额。
 * (m - (n - 1))用来确保剩余的n-1人最少可以领取到1元红包。
 * @author JustJavaIt
 * @date 2022/9/23 14:46
 */
public class redpacket {
    public static void main(String[] args) {
        int[] result = new int[10];
        randomRedPacket(100,10,result);
        System.out.println("方法一: " + Arrays.toString(result));

        int[] result2 = new int[10];
        randomRedPacket2(100,10,result2);
        System.out.println("方法二: " + Arrays.toString(result2));

        int[] result3 = new int[10];
        randomRedPacket3(100,10,result3);
        System.out.println("方法三: " + Arrays.toString(result3));

    }

    /**
     * [15, 29, 48, 2, 1, 1, 1, 1, 1, 1]
     * 这个算法并没有实现完全的随机，排在前边的人，他们的可选区间越大，抢到大红包的可能性越大，
     * 而排在后边的人，他们的可选区间受前人影响，在前人的大快朵颐之后，只能吃些残渣剩饭了。
     * @param m
     * @param n
     * @param result
     */
    private static void randomRedPacket(int m, int n, int[] result){
        //当前已经有多少人领取过红包
        int index = result.length - n;
        //如果是最后一个人，则将红包剩余金额全部给这个人，并结束循环
        if(index == result.length - 1){
            result[index] = m;
            return ;
        }
        //从剩下的金额中分配随机金额
        int randomValue = (int) (Math.random() * (m - (n - 1)) + 1);
        result[index] = randomValue;
        randomRedPacket(m - randomValue, n - 1, result);
    }

    /**
     * 方法二 改进
     * 还有n个人未领取，红包剩余金额为m元
     * 这个算法并不完美，最终生成的红包金额都比较趋近于平均值，
     * @param m
     * @param n
     * @param result
     */
    private static void randomRedPacket2(int m, int n, int[] result){
        //每人先领取一元低保
        Arrays.fill(result, 1);
        //将剩下的m-n元，随机分配给其中的一个人
        for (int i = 0; i < m - n; i++) {
            result[new Random().nextInt(n)] += 1;
        }
    }

    /**
     * 方法3
     * 还有n个人未领取，红包剩余金额为m元
     * @param m
     * @param n
     * @param result
     */
    private static void randomRedPacket3(int m, int n, int[] result){
        //每人先领取一元低保
        Arrays.fill(result, 1);
        //初始化一个位置数组，用于存储随机位置
        int[] indexArr = new int[n - 1];
        int lastMoney = m - n;
        for (int i = 0; i < n - 1; i++) {
            int index = (new Random().nextInt(lastMoney));
            indexArr[i] = index;
        }
        //对分段的位置按照从小打到排序
        Arrays.sort(indexArr);
        //将n-1个位置切割成的n段，依次分配给n个人
        for (int i = 0; i < result.length; i++) {
            if(i == 0){
                result[i] += indexArr[i];
            }else if(i == n - 1){
                //最后一个
                result[i] += lastMoney - indexArr[i - 1];
            }else{
                result[i] += indexArr[i] - indexArr[i - 1];
            }
        }
    }

}
