package com.java.interview.other.design.facadePattern.gpt;

/**
 * 子系统
 *
 * @author 79183
 * @date 2024/7/5 10:07
 */
public class TV implements ElectricalAppliances {
    @Override
    public void on() {
        System.out.println("打开电视");
    }

    @Override
    public void off() {
        System.out.println("关闭电视");
    }
}
