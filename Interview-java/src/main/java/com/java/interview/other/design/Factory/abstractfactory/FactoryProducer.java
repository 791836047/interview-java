package com.java.interview.other.design.Factory.abstractfactory;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 * @author 79183
 * @date 2024/6/14 10:16
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
