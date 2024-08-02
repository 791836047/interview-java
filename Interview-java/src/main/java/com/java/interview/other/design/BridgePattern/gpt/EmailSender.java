package com.java.interview.other.design.BridgePattern.gpt;

/**
 * Step 2: 提供具体的实现类（Concrete Implementor）
 * 接着，提供两个不同的 MessageSender 实现，分别用于通过电子邮件和短信发送消息。
 * @author 79183
 * @date 2024/6/17 16:13
 */
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email with message: " + message);
    }
}
