package com.java.interview.other.design.observer;

/**
 * 创建实体观察者类
 * @author liaowenhui
 * @date 2022/4/14 10:41
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
