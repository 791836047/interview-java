package com.java.interview.other.design.BuilderPattern;

/**
 * @author liaowenhui
 * @date 2023/10/30 16:06
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
