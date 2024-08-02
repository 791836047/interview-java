package com.java.interview.other.design.Factory.gpt.simpleFactoryDemo;

/**
 *  简单工厂类(静态工厂累)
 * @author 79183
 * @date 2024/6/14 11:25
 */
public class SimpleFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcreteProductB();
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
}
