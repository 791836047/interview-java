package com.java.interview.other.design.facadePattern.cainiao;

/**
 * @author 79183
 * @date 2024/7/5 9:55
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
