package com.java.interview.other.design.observer;

/**
 * @author liaowenhui
 * @date 2022/4/14 10:40
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
