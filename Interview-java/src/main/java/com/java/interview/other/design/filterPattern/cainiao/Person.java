package com.java.interview.other.design.filterPattern.cainiao;

/**
 * 创建一个类，在该类上应用标准。
 * @author 79183
 * @date 2024/7/3 14:40
 */
public class Person {

    private String name;
    private String gender;
    //婚姻状态
    private String maritalStatus;

    public Person(String name,String gender,String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
}
