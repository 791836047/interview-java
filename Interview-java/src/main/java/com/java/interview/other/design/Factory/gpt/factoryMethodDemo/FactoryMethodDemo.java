package com.java.interview.other.design.Factory.gpt.factoryMethodDemo;

/**
 * @author 79183
 * @date 2024/6/14 11:32
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.createProduct();
        productA.use();

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.createProduct();
        productB.use();
    }
}
