package com.java.interview.other.design.Factory;

/**
 *
 * @author liaowenhui
 * @date 2023/2/6 15:57
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
