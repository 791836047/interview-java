package com.java.interview.other.design.BridgePattern.demo1;

/**
 * @author liaowenhui
 * @date 2023/11/6 17:49
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
