package com.java.interview.other.design.CommandPattern.cainiao;

/**
 * 创建实现了 Order 接口的实体类。
 * @author liaowenhui
 * @date 2023/10/30 14:58
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
