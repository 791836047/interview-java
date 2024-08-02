package com.java.interview.other.design.statusPattern;

/**
 * 定义一个抽象的状态类
 * @author liaowenhui
 * @date 2023/7/27 14:26
 */
public abstract class State {
    Context context;
    public void setContext(Context context) {
        this.context = context;
    }
    public abstract boolean handle1();
    public abstract void handle2();
}
