package com.java.interview.other.design.statusPattern;

/**
 * 定义状态B
 * @author liaowenhui
 * @date 2023/7/27 14:28
 */
public class ConcreteStateB extends State {
    @Override
    public boolean handle1() {
        //本状态下必须要处理的事情
        System.out.println("状态B下业务逻辑");
        return true;
    }

    @Override
    public void handle2() {
        //切换到状态C
    }
}
