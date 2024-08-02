package com.java.interview.other.design.Factory.abstractfactory;


import com.java.interview.other.design.Factory.Shape;

/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 * @author 79183
 * @date 2024/6/14 10:14
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
