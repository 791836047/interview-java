package com.java.interview.other.design.StrategyPattern;


/**
 *
 * @author liaowenhui
 * @date 2023/2/20 10:28
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
