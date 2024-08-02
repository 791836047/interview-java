package com.java.interview.other.design.CommandPattern.cainiao;

/**
 * 使用 Broker 类来接受并执行命令。
 * @author liaowenhui
 * @date 2023/10/30 14:59
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
