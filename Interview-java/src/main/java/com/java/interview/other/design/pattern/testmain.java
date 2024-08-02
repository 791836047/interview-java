package com.java.interview.other.design.pattern;

/**
 * @author liaowenhui
 * @date 2023/11/8 14:29
 */
public class testmain {
    public static void main(String[] args) {
        Engine electricEngine = new ElectricEngine();
        Tire winterTire = new WinterTire();

        Car electricCarWithWinterTires = new Car(electricEngine, winterTire);
        electricCarWithWinterTires.start();
        electricCarWithWinterTires.drive();
    }
}
