package com.java.interview.other;/**
 * @author liaowenhui
 * @date 2022/9/22 16:51
 */

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author liaowenhui
 * @date 2022/9/22 16:51
 */
public class test3 {

    public static void main(String[] args) {
        String s = convertListToString(Arrays.asList("123", "456"));
        System.out.println("转化后：" + "(" + s + ")");
    }

    /**
     * 需求分析：优化接口时,需要手动拼接sql去调取神策的接口获取数据
     * 将List<String> = {"123","456"}集合转化为('123','456')
     */
    public static String convertListToString(List<String> strlist) {
        StringBuilder sb = new StringBuilder();
        if (!CollectionUtils.isEmpty(strlist)) {
            for (int i = 0; i < strlist.size(); i++) {
                if (i == 0) {
                    sb.append("'").append(strlist.get(i)).append("'");
                } else {
                    sb.append(",").append("'").append(strlist.get(i)).append("'");
                }
            }
        }
        return sb.toString();
    }

}
