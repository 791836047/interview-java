package com.java.interview.other.design;

/**
 * 单例模式  拼多多、百度一面手写
 * @author liaowenhui
 * @date 2022/4/14 9:51
 */
public class Singleton {
    /**
     * 要点二:单例类必须自己创建自己的唯一实例。
     * 具体实现二：创建一个该类的静态私有对象
     */
    private static volatile Singleton singleton;

    /**
     * 要点一:单例类只能有一个实例。
     * 具体实现一：让构造函数为 private，这样该类就不会被实例化.
     */
    private Singleton() {
    }

    /**
     * 要点三：单例类必须自行向整个系统提供这个实例。
     * 具体实现三：提供了一个静态的公有的函数用于创建或获取它本身的静态私有对象。
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
