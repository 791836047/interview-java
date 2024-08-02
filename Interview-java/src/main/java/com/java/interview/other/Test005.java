package com.java.interview.other;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * BeanUtils.copyProperties()是浅拷贝
 * @author 79183
 * @date 2024/3/21 14:47
 */
public class Test005 {
    public static void main(String[] args) {
        User originalUser = new User();
        originalUser.setName("John");
        Address originalAddress = new Address();
        originalAddress.setStreet("123 Main St");
        originalAddress.setCity("Springfield");
        originalUser.setAddress(originalAddress);

        User shallowCopy = new User();
        BeanUtils.copyProperties(originalUser, shallowCopy);

        // 修改原始对象的Address属性
        originalAddress.setStreet("456 Elm St");

        System.out.println(shallowCopy.getAddress().getStreet());
    }

    @Data
    static class Address {
        private String street;
        private String city;
    }

    @Data
    static class User {
        private String name;
        private Address address;
    }
}
