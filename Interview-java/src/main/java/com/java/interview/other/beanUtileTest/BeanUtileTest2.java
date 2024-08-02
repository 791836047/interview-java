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
public class BeanUtileTest2 {
    public static void main(String[] args) {
        // 源类
        FastdfsTest source = new FastdfsTest();
        source.setId("1");
        source.setName("广州城市");
        source.setSize("100");
        CityBean cityBean = new CityBean();
        cityBean.setValue("广州");
        source.setCityBean(cityBean);

        // 目标类
        FastdfsTest target = new FastdfsTest();
        // 把fastdfsTest中所有的属性都复制到fastdfsTestCopy中，即使是cityBean也会被复制
        BeanUtils.copyProperties(source, target);

        //source.setCityBean(null);

        CityBean sourceCity = source.getCityBean();
        //在下面改变源类的引用数据，如果BeanUtils.copyProperties是浅拷贝，那么目标类拷贝的就是一个引用地址；源类改变目标类也会跟着改变
        //如果BeanUtils.copyProperties是深拷贝，则两边改变都不会相互影响
        sourceCity.setValue("上海");

        System.out.println("source中的CityBean:"+ source.getCityBean().getValue());
        System.out.println("target中的CityBean:"+ target.getCityBean().getValue());
        System.out.println(source.getCityBean()==(target.getCityBean()));
    }
}
