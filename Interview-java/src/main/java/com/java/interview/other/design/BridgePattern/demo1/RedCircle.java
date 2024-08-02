package com.java.interview.other.design.BridgePattern.demo1;

/**
 * @author liaowenhui
 * @date 2023/11/6 17:49
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
