package com.java.interview.other.design.templatePattern;

/**
 * @author liaowenhui
 * @date 2022/4/14 14:45
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
