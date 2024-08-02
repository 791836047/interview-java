package com.java.interview.other.java8new;

/**
 * @author liaowenhui
 * @date 2023/8/10 15:00
 */
public class Main {
    private LockService lockService = new LockService();

    public static void main(String[] args) {
        Main main = new Main();
        main.process("123456");
    }

    private void process(String orderId) {
        Boolean processSuccess = lockService.executeWithLock(LockBizType.ORDER, orderId, () -> doProcess(orderId));
        // do something with processSuccess
    }

    private Boolean doProcess(String orderId) {
        //比如将订单数据写入数据库、执行交易操作、发送通知等等
        // Simulate processing logic

        System.out.println("Processing order: " + orderId);
        return Boolean.TRUE;
    }
}
