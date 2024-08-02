package com.java.interview.other.design.BridgePattern.demo1;

/**
 * @author liaowenhui
 * @date 2023/11/6 17:48
 */
public interface DrawAPI {
    /**
     * radius半径
     * @param radius
     * @param x
     * @param y
     */
    public void drawCircle(int radius, int x, int y);
}
