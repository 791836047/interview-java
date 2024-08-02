package com.java.interview.other.jdkProxy;

/**
 * 测试类
 * @author liaowenhui
 * @date 2022/3/9 11:18
 */
public class Test {
    public static void main(String[] args) {
        TestJDKProxy jdkProxy = new TestJDKProxy();
        JDKProxyTestService proxy = (JDKProxyTestService) jdkProxy.newProxy(new JDKProxyTestServiceImpl());
        proxy.run();
    }
}
