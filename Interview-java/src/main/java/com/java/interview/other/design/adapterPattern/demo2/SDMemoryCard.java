package com.java.interview.other.design.adapterPattern.demo2;

/**
 * 内存卡的具体实现类
 * @author liaowenhui
 * @date 2023/12/1 10:45
 */
class SDMemoryCard implements MemoryCard {
    @Override
    public void readData() {
        System.out.println("Reading data from SD memory card...");
    }
}
