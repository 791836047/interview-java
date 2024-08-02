package com.java.interview.other.design.BridgePattern.gpt;

/**
 * Step 5: 使用桥接模式
 * 现在，我们可以创建不同的消息类型，并通过不同的渠道发送消息。
 * @author 79183
 * @date 2024/6/17 16:15
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SmsSender();

        Message textMessage = new TextMessage(emailSender);
        Message multimediaMessage = new MultimediaMessage(smsSender);

        textMessage.send("Hello, this is a text message!");
        multimediaMessage.send("Hello, this is a multimedia message!");
    }
}
