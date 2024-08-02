package com.java.interview.other.ImmutableMap;


import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;

/**
 * 通过map+Function优化if else
 *
 * 在实际项目中，ImmutableMap<Integer, Function<Object, String>> 可以用于实现基于状态机的逻辑处理。
 * 例如，考虑一个简单的订单处理系统，其中订单有不同的状态（比如新建、已支付、已发货、已收货等），并且每个状态都有对应的处理逻辑。
 * @author liaowenhui
 * @date 2023/5/4 14:01
 */
@Data
public class Order {
    private final String orderId;
    private final OrderStatus status;

    public Order(String orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public static final ImmutableMap<OrderStatus , Function<Order, String>> STATUS_HANDLERS =
            ImmutableMap.<OrderStatus, Function<Order, String>>builder()
                    .put(OrderStatus.NEW, Order::handleNewOrder)
                    .put(OrderStatus.PAYMENT_RECEIVED, Order::handlePayment)
                    .put(OrderStatus.SHIPPED, Order::handleShipment)
                    .put(OrderStatus.DELIVERED, Order::handleDelivered)
                    .build();

    public String process() {
        Function<Order, String> handler = STATUS_HANDLERS.get(status);
        if (handler == null) {
            return "Invalid order";
        }
        return handler.apply(this);
    }

    public String process2() {
        switch (status) {
            case NEW:
                return handleNewOrder();
            case PAYMENT_RECEIVED:
                return handlePayment();
            case SHIPPED:
                return handleShipment();
            case DELIVERED:
                return handleDelivered();
            default:
                return "Invalid order";
        }
    }

    private String handleNewOrder() {
        // Handle new order logic here
        return "Order " + orderId + " 新建";
    }

    private String handlePayment() {
        // Handle payment logic here
        return "Order " + orderId + " 已支付";
    }

    private String handleShipment() {
        // Handle shipment logic here
        return "Order " + orderId + " 已发货";
    }

    private String handleDelivered() {
        // Handle delivered logic here
        return "Order " + orderId + " 已收获";
    }

    public static void main(String[] args) {
        Order order = new Order("12345", OrderStatus.SHIPPED);
        //if else方式
        String result2 = order.process2();
        //map + Function的方式
        String result = order.process();

        System.out.println(result);
        System.out.println(result2);
    }
}
