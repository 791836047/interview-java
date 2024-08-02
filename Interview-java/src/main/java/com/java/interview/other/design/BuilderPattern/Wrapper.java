package com.java.interview.other.design.BuilderPattern;

/**
 * 用纸盒包装
 * @author liaowenhui
 * @date 2023/10/30 16:06
 */
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
