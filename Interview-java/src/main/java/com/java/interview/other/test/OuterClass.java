package com.java.interview.other.test;

/**
 * 内部类
 *
 *  我们通过javac编译后发现
 * 在虚拟机中没有外部类内部类之分都是普通的类，但是编译器会偷偷的做点修改，让内部类中多一个常量引用，指向外部类，
 * 同时自动修改内部类构造器，初始化这个常量引用，而外部类会扫描内部类是否调用了外部类的私有属性，
 * 如果调用了，会为这些私有属性创造acess$xxx静态方法。这个方法是返回对应的私有属性的值。所以可以在一个类的外部获取一个类的私有属性的值。

 *
 * @author liaowenhui
 * @date 2022/7/29 9:52
 */
public class OuterClass {
    private String name;
    private int id;
    private String addreee;

    public class InnerClass{
        private String innerName;

        public void fun(){
            System.out.println(OuterClass.this.name + "" + innerName);
        }

        public InnerClass(String innerName) {
            this.innerName = innerName;
        }
    }


}
