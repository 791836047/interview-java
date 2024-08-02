package com.java.interview.other.design.decoratorPattern.cainiao;

/**
 * 创建扩展了 ShapeDecorator 类的实体装饰类。
 * @author liaowenhui
 * @date 2023/4/6 10:26
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
