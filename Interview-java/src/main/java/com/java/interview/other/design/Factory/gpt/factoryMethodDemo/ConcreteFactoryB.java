package com.java.interview.other.design.Factory.gpt.factoryMethodDemo;

/**
 *  具体工厂B
 * @author 79183
 * @date 2024/6/14 11:31
 */
class ConcreteFactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
