package com.java.interview.other.design.proxyPattern;

/**
 * @author liaowenhui
 * @date 2023/4/6 11:02
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
