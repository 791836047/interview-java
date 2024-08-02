package com.java.interview.other.design.statusPattern;

/**
 * 定义一个上下文管理环境
 */
public class Context {
    public final static ConcreteStateA contreteStateA = new ConcreteStateA();
    public final static ConcreteStateB contreteStateB = new ConcreteStateB();
    private State currentState;
    public State getCurrentState() {return currentState;}

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public boolean handle1() {return currentState.handle1();}

    public void handle2() {currentState.handle2();}
}
