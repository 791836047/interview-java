package com.java.interview.other.design.BuilderPattern;

/**
 * @author liaowenhui
 * @date 2023/10/30 16:07
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
