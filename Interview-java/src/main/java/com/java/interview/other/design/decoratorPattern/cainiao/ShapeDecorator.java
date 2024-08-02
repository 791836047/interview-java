package com.java.interview.other.design.decoratorPattern.cainiao;

/**
 *  创建实现了 Shape 接口的抽象装饰类。
 * @author liaowenhui
 * @date 2023/4/6 10:24
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
