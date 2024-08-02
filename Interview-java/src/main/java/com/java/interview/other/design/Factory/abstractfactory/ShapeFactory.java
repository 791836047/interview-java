package com.java.interview.other.design.Factory.abstractfactory;


import com.java.interview.other.design.Factory.Circle;
import com.java.interview.other.design.Factory.Rectangle;
import com.java.interview.other.design.Factory.Shape;
import com.java.interview.other.design.Factory.Square;

/**
 * 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 * @author 79183
 * @date 2024/6/14 10:15
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
