package com.java.interview.other.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowenhui
 * @date 2022/4/14 10:40
 */
public class Subject {
    private List<Observer> observers
            = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
