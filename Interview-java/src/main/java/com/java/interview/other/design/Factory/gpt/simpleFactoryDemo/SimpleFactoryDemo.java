package com.java.interview.other.design.Factory.gpt.simpleFactoryDemo;

/**
 * @author 79183
 * @date 2024/6/14 11:25
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct("A");
        productA.use();

        Product productB = SimpleFactory.createProduct("B");
        productB.use();
    }
}
