package com.java.interview.other.design.facadePattern.gpt;

/**
 * @author 79183
 * @date 2024/7/5 10:08
 */
class AirCondition implements ElectricalAppliances {
    @Override
    public void on() {
        System.out.println("打开空调");
    }

    @Override
    public void off() {
        System.out.println("关闭空调");
    }
}
