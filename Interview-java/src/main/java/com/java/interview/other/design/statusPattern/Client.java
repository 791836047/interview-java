package com.java.interview.other.design.statusPattern;

/**
 * 定义client执行
 * @author liaowenhui
 * @date 2023/7/27 14:29
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        if (context.handle1()){
            context.handle2();
        }
    }
}
