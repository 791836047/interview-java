package com.java.interview.other.design.BridgePattern.gpt;

/**
 * Step 1: 定义实现部分接口（Implementor）
 * 首先，定义一个 MessageSender 接口，用于发送消息。
 * @author 79183
 * @date 2024/6/17 16:13
 */
public interface MessageSender {
    void sendMessage(String message);
}
