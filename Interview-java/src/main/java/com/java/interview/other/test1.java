package com.java.interview.other;

import lombok.var;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author liaowenhui
 * @date 2022/5/19 14:39
 */
public class test1 {
    public static void main(String[] args) {

        //后台正确填写
        String a = "1,2,3,4,5";
        String[] splita = a.split(",");
        System.out.println("splita:" + splita.length);

        //后台错误填写 用户不小心用了中文的逗号
        String b = "1，2，3，4，5";
        String[] splitb = b.split(",");
        //结果为1，说明切片失败
        System.out.println("splitb:" + splitb.length);

        //兼容推荐写法 a.split(“[,，]”)就是将字符串a按照逗号或者中文逗号进行切片，返回切片后的字符串列表。
        String[] splitc = b.split("[,，]");
        System.out.println("splitc:" + splitc.length);

    }

}
