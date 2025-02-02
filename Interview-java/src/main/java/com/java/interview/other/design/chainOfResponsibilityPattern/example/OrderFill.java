package com.java.interview.other.design.chainOfResponsibilityPattern.example;

/**
 * 补充订单信息
 */
public class OrderFill extends Handler {

    @Override
    public void process(OrderInfo order) {
        System.out.println("补充订单信息");
        handler.process(order);
    }

}
