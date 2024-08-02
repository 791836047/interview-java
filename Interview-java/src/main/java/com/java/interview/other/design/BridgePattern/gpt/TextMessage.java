package com.java.interview.other.design.BridgePattern.gpt;

/**
 * Step 4: 提供具体的消息类（Refined Abstraction）
 * 接着，定义具体的消息类型，例如 TextMessage 和 MultimediaMessage。
 * @author 79183
 * @date 2024/6/17 16:14
 */
public class TextMessage extends Message {

    public TextMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("Text: " + message);
    }
}
