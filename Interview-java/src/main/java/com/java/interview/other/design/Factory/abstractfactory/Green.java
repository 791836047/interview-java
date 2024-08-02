package com.java.interview.other.design.Factory.abstractfactory;


/**
 * @author 79183
 * @date 2024/6/14 10:12
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
