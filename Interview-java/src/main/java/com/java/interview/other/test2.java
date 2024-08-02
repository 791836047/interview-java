package com.java.interview.other;

/**
 * while 中return
 * @author liaowenhui
 * @date 2022/6/30 16:23
 */
public class test2 {
    public static void main(String[] args) {
        int i = 2;
        while (i > 0) {
            for (int j = 0; j < 2; j++) {
                System.out.println(j);

                //break是跳出了for循环。
                break;

               /* //return会直接把整个双重循环给跳出。
                return;*/
            }
            i--;
            System.out.println(i);
        }
    }
}
