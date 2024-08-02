package com.java.interview.other.design.CommandPattern.cainiao;

/**
 * 创建一个股票请求类。
 * @author liaowenhui
 * @date 2023/10/30 14:57
 */
public class Stock {
    private final String name = "ABC";
    private final int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+ name
                +", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name
                + ", Quantity: " + quantity +" ] sold");
    }
}
