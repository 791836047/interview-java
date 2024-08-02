package com.java.interview.other.design.statusPattern;

/**
 * 定义状态A
 * @author liaowenhui
 * @date 2023/7/27 14:27
 */
public class ConcreteStateA extends State {
    @Override
    public boolean handle1() {
        //本状态下必须要处理的事情
        System.out.println("状态A下业务逻辑");
        return true;
    }

    @Override
    public void handle2() {
        //切换到状态B
        super.context.setCurrentState(Context.contreteStateB);
        //执行状态B的任务
        super.context.handle1();
    }
}
