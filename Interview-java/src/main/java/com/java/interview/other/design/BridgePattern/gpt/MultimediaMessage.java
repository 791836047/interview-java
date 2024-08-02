package com.java.interview.other.design.BridgePattern.gpt;

/**
 * @author 79183
 * @date 2024/6/17 16:15
 */
public class MultimediaMessage extends Message {

    public MultimediaMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("Multimedia: " + message);
    }
}
