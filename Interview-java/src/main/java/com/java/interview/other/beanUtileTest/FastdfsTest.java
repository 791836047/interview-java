package com.java.interview.other.beanUtileTest;/**
 * @author liaowenhui
 * @date 2023/1/7 15:17
 */

import lombok.Data;

/**
 *
 * @author liaowenhui
 * @date 2023/1/7 15:17
 */
@Data
public class FastdfsTest {
    private String id;
    private String name;
    private String size;
    private CityBean cityBean;

    public FastdfsTest(String id, String name, String size, CityBean cityBean) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.cityBean = cityBean;
    }

    public FastdfsTest() {
    }
}
