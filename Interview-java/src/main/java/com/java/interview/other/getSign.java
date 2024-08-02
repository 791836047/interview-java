package com.java.interview.other;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.*;

/**
 * 签名
 * @author liaowenhui
 * @date 2023/6/19 17:19
 */
public class getSign {

    public static void main(String[] args) {

        TreeMap param = new TreeMap();
        param.put("requestId", "123");
        param.put("time", "123431123");
        param.put("eventType", "pay");

        //生成签名字符串
        String signContent = getSignContent(param);
        //对signContent进行MD5加密
        System.out.println("sign param :" + signContent);
    }


    /**
     * 参数格式转换Map转String
     *
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<>(sortedParams.keySet());
        //Collections.sort(keys);
        int index = 0;
        for (String key : keys) {
            String value = sortedParams.get(key);
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                content.append(index == 0 ? "" : "&").append(key).append("=").append(value);
                index++;
            }
        }
        return content.toString();
    }
}
