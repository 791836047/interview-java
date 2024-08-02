package com.java.interview.other.java8new.anonymous;

/**
 * 菜鸟--https://www.runoob.com/java/java-anonymous-class.html
 * 匿名类继承一个父类
 * 创建了 Polygon 类，该类只有一个方法 display()，AnonymousDemo 类继承了 Polygon 类并重写了 Polygon 类的 display() 方法:
 * @author liaowenhui
 * @date 2022/1/12 13:40
 */
public class AnonymousDemo {

    public static void main(String[] args) {
        AnonymousDemo an = new AnonymousDemo();
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

    class Polygon {
        public void display() {
            System.out.println("在 Polygon 类内部");
        }
    }



}
