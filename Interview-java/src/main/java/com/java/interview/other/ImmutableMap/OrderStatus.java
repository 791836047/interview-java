package com.java.interview.other.ImmutableMap;

/**
 * 订单状态
 * @author liaowenhui
 * @date 2023/5/4 14:38
 */
public enum OrderStatus {
    /**
     * 新建
     * 已付款
     * 已发货
     * 已收货
     */
    NEW,
    PAYMENT_RECEIVED,
    SHIPPED,
    DELIVERED
}
