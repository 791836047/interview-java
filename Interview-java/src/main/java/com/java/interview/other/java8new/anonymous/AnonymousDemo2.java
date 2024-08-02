package com.java.interview.other.java8new.anonymous;

/**
 * 匿名类实现一个接口
 * @author liaowenhui
 * @date 2022/1/12 13:40
 */
public class AnonymousDemo2 {

    public static void main(String[] args) {
        AnonymousDemo2 an = new AnonymousDemo2();
        an.createClass();
    }

    public void createClass() {
        // 创建的匿名类继承了 Polygon 类
        Polygon p1 = new Polygon() {
            @Override
            public void display() {
                System.out.println("在匿名类内部。");
            }
        };
        p1.display();
    }

    interface Polygon {
        public void display();
    }


}
