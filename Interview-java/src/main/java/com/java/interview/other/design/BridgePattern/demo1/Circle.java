package com.java.interview.other.design.BridgePattern.demo1;

/**
 * @author liaowenhui
 * @date 2023/11/6 17:49
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
