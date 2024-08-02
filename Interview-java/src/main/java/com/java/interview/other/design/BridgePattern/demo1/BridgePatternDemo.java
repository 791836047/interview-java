package com.java.interview.other.design.BridgePattern.demo1;

/**
 * 使用 Shape 和 DrawAPI 类画出不同颜色的圆。
 *
 * @author liaowenhui
 * @date 2023/11/6 17:50
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
