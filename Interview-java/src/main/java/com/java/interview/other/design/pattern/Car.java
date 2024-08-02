package com.java.interview.other.design.pattern;

/**
 * @author liaowenhui
 * @date 2023/11/8 14:29
 */
class Car {
    private Engine engine;
    private Tire tire;

    public Car(Engine engine, Tire tire) {
        this.engine = engine;
        this.tire = tire;
    }

    public void start() {
        engine.start();
    }

    public void drive() {
        tire.inflate();
        System.out.println("Car is driving.");
    }
}
