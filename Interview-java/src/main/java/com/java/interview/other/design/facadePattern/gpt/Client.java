package com.java.interview.other.design.facadePattern.gpt;

/**
 * @author 79183
 * @date 2024/7/5 10:08
 */
public class Client {
    public static void main(String[] args) {
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        // 控制家电
        facade.say("打开家电");
        facade.say("关闭家电");
    }
}
