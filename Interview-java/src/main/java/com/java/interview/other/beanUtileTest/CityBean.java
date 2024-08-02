package com.java.interview.other.beanUtileTest;/**
 * @author liaowenhui
 * @date 2023/1/7 15:16
 */

import lombok.Data;

/**
 *
 * @author liaowenhui
 * @date 2023/1/7 15:16
 */
@Data
public class CityBean {
    String value;

    public CityBean(String value) {
        this.value = value;
    }

    public CityBean() {
    }
}
