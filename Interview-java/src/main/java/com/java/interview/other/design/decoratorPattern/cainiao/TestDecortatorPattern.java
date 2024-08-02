package com.java.interview.other.design.decoratorPattern.cainiao;

/**
 * @author liaowenhui
 * @date 2023/4/6 10:27
 */
public class TestDecortatorPattern {

    /**
     * 使用 RedShapeDecorator 来装饰 Shape 对象。
     * @param args
     */
    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
