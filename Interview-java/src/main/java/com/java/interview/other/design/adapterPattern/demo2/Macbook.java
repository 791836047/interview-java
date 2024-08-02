package com.java.interview.other.design.adapterPattern.demo2;

/**
 * 笔记本的具体实现类
 * @author liaowenhui
 * @date 2023/12/1 10:45
 */
class Macbook implements Laptop {
    @Override
    public void writeToLaptop() {
        System.out.println("Writing to Macbook...");
    }
}
