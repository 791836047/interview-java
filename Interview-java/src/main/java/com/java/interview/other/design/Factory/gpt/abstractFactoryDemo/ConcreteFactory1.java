package com.java.interview.other.design.Factory.gpt.abstractFactoryDemo;


/**
 * 具体工厂2
 * @author 79183
 * @date 2024/6/14 11:35
 */
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
