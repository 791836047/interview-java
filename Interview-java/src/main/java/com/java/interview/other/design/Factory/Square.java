package com.java.interview.other.design.Factory;

/**
 *
 * @author liaowenhui
 * @date 2023/2/6 15:57
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
