package com.java.interview.other.design.BridgePattern.gpt;

/**
 * Step 3: 定义抽象类（Abstraction）
 * 定义一个 Message 抽象类，它持有一个 MessageSender 对象，并定义发送消息的方法。
 * @author 79183
 * @date 2024/6/17 16:14
 */
public abstract class Message {
    protected MessageSender messageSender;

    protected Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String message);
}
