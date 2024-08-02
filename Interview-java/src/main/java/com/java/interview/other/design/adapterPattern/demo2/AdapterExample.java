package com.java.interview.other.design.adapterPattern.demo2;

/**
 * 客户端代码
 * @author liaowenhui
 * @date 2023/12/1 10:46
 */
public class AdapterExample {
    public static void main(String[] args) {
        // 创建一个SD内存卡和Macbook笔记本
        MemoryCard sdCard = new SDMemoryCard();
        Laptop macbook = new Macbook();

        // 使用读卡器适配器来将SD内存卡适配到Macbook笔记本上
        Laptop cardReaderAdapter = new CardReaderAdapter(sdCard);

        // 写入笔记本
        cardReaderAdapter.writeToLaptop();
    }
}
