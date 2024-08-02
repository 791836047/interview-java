package com.java.interview.other.design.BuilderPattern;

/**
 * @author liaowenhui
 * @date 2023/10/30 16:07
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
