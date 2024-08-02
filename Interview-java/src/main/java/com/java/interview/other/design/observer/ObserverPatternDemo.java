package com.java.interview.other.design.observer;

/**
 * @author liaowenhui
 * @date 2022/4/14 10:41
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        //发短信
        new HexaObserver(subject);
        //发邮件
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
