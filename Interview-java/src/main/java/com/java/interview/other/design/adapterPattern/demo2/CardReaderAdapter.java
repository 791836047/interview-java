package com.java.interview.other.design.adapterPattern.demo2;

/**
 * 读卡器适配器
 * @author liaowenhui
 * @date 2023/12/1 10:46
 */
public class CardReaderAdapter implements Laptop {

    private MemoryCard memoryCard;

    public CardReaderAdapter(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void writeToLaptop() {
        // 读卡器将内存卡数据读取，并写入笔记本
        memoryCard.readData();
        System.out.println("Transferring data to the laptop...");
    }
}
