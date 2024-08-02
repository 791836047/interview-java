package com.java.interview.other.design.StrategyPattern;

/**
 *
 * @author liaowenhui
 * @date 2023/2/20 10:30
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
