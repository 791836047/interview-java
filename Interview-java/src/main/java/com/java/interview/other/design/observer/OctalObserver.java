package com.java.interview.other.design.observer;

import java.util.Observable;

/**
 * 创建实体观察者类
 * @author liaowenhui
 * @date 2022/4/14 10:41
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }


}
