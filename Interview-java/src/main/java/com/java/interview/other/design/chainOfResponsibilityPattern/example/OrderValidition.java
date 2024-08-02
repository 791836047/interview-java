package com.java.interview.other.design.chainOfResponsibilityPattern.example;

/**
 * 订单校验
 */
public class OrderValidition extends Handler {

    @Override
    public void process(OrderInfo order) {
        System.out.println("校验订单基本信息");
        //下一步：补充订单信息
        handler.process(order);
    }

}


