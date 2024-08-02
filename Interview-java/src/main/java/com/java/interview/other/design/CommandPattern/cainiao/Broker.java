package com.java.interview.other.design.CommandPattern.cainiao;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建命令调用类。
 * @author liaowenhui
 * @date 2023/10/30 14:58
 */
public class Broker {
    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
