package com.java.interview.other.design.chainOfResponsibilityPattern.example;

/**
 * 订单入库
 */
public class OrderCreate extends Handler {

    @Override
    public void process(OrderInfo order) {
        System.out.println("订单入库");
    }
}
