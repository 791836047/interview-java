package com.java.interview.other.design.Factory.gpt.abstractFactoryDemo;


/**
 * @author 79183
 * @date 2024/6/14 11:35
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.use();
        productB1.use();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.use();
        productB2.use();
    }
}
