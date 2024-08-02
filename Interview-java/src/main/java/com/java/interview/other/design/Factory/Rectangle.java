package com.java.interview.other.design.Factory;

/**
 *
 * @author liaowenhui
 * @date 2023/2/6 15:56
 */
public class Rectangle  implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
