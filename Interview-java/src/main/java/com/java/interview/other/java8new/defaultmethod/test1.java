package com.java.interview.other.java8new.defaultmethod;

/**
 * @author liaowenhui
 * @date 2022/1/14 10:26
 */
public class test1 {

    public static void main(String args[]) {
        Car car1 = new Car();
        car1.print();
    }

    interface Vehicle {
        default void print() {
            System.out.println("我是一辆车!");
        }

        static void blowHorn() {
            System.out.println("按喇叭!!!");
        }
    }

    interface FourWheeler {
        default void print() {
            System.out.println("我是一辆四轮车!");
        }
    }

    static class Car implements Vehicle, FourWheeler {
        @Override
        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车!");
        }
    }
}
