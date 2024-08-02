package com.java.interview.other.design.BridgePattern.gpt;

/**
 * @author 79183
 * @date 2024/6/17 16:13
 */
public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}
