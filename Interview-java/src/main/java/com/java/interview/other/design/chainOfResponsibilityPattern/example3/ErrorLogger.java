package com.java.interview.other.design.chainOfResponsibilityPattern.example3;

/**
 * @author liaowenhui
 * @date 2022/4/25 14:12
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
