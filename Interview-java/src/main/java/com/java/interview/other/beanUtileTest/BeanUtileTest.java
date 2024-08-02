package com.java.interview.other.beanUtileTest;/**
 * @author liaowenhui
 * @date 2023/1/7 15:17
 */

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author liaowenhui
 * @date 2023/1/7 15:17
 */
public class BeanUtileTest {
    public static void main(String[] args) {
        List<FastdfsTest> fastdfsTestList = new ArrayList<>();
        FastdfsTest data1 = new FastdfsTest("1", "广州城市", "100", new CityBean("广州"));
        fastdfsTestList.add(data1);
        //FastdfsTest data2 = new FastdfsTest("2", "深圳", "100", new CityBean("深圳城市"));
        //fastdfsTestList.add(data2);

        // 拷贝
        List<FastdfsTest> newFastdfsTestList = fastdfsTestList.stream().map(k -> {
            FastdfsTest fastdfsTest = new FastdfsTest();
            BeanUtils.copyProperties(k, fastdfsTest);
            return fastdfsTest;
        }).collect(Collectors.toList());

        // 设置源对象引用字段为空
        //fastdfsTestList.get(0).getCityBean().setValue(null);
        fastdfsTestList.get(0).setCityBean(null);

        System.out.println("fastdfsTestList:===" + fastdfsTestList);
        System.out.println("newFastdfsTestList:===" + newFastdfsTestList);
        System.out.println(fastdfsTestList.get(0).getCityBean()==(newFastdfsTestList.get(0).getCityBean()));

    }
}
