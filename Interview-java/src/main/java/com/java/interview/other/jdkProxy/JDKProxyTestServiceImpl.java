package com.java.interview.other.jdkProxy;

/**
 * 目标类
 * @author liaowenhui
 * @date 2022/3/9 11:15
 */
public class JDKProxyTestServiceImpl implements JDKProxyTestService {
    @Override
    public void run() {
        System.out.println("do something...");
    }
}
