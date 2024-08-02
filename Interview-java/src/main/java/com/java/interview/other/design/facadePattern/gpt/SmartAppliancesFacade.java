package com.java.interview.other.design.facadePattern.gpt;

/**
 * 假设我们有一套智能家电，包括电视、灯和空调。每个家电都有自己的开启和关闭方法。
 * 如果我们按下一键启动开关，就希望能够一次性打开或关闭所有家电。
 * 这时，我们可以使用外观模式将这些操作封装在一起，提供一个简单的接口给客户端使用。
 *
 * @author 79183
 * @date 2024/7/5 10:08
 */
public class SmartAppliancesFacade {
    private ElectricalAppliances light;
    private ElectricalAppliances tv;
    private ElectricalAppliances airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    // 通过语音控制
    public void say(String message) {
        if (message.contains("打开")) {
            on();
        } else if (message.contains("关闭")) {
            off();
        } else {
            System.out.println("抱歉，我听不懂");
        }
    }

    // 一键打开功能
    private void on() {
        tv.on();
        light.on();
        airCondition.on();
    }

    private void off() {
        tv.off();
        light.off();
        airCondition.off();
    }
}
