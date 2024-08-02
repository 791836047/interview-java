package com.java.interview.other.design.facadePattern.cainiao;

/**
 * 外观模式
 * @author 79183
 * @date 2024/7/5 9:55
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
