package com.java.interview.other.design.chainOfResponsibilityPattern.example;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单信息类
 */
@Data
public class OrderInfo {

    private String productId;
    private String userId;
    private BigDecimal amount;

}
