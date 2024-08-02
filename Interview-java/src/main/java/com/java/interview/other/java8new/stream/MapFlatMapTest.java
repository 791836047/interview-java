package com.java.interview.other.java8new.stream;

import com.alibaba.fastjson.JSON;
import com.java.interview.other.java8new.FinanceStatisticsDto;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 * @author liaowenhui
 * @date 2022-09-22
 */
public class MapFlatMapTest {
    public static void main(String[] args) {

        /**
         * 需求分析：同一公司，同一产品可能有多条广告计划，每条广告计划的消耗不同，财务统计页面需要按天统计不同产品的消耗总和。
         */
        LinkedList<FinanceStatisticsDto> processList = new LinkedList<>();
        FinanceStatisticsDto dto1 = new FinanceStatisticsDto().setDate("2022-09-21").setDeptName("字节").setProductName("飞书").setConsumption(new BigDecimal(50));
        FinanceStatisticsDto dto2 = new FinanceStatisticsDto().setDate("2022-09-21").setDeptName("字节").setProductName("抖音").setConsumption(new BigDecimal(100));
        FinanceStatisticsDto dto3 = new FinanceStatisticsDto().setDate("2022-09-21").setDeptName("字节").setProductName("飞书").setConsumption(new BigDecimal(100));
        FinanceStatisticsDto dto4 = new FinanceStatisticsDto().setDate("2022-09-20").setDeptName("字节").setProductName("飞书").setConsumption(new BigDecimal(75));
        FinanceStatisticsDto dto5 = new FinanceStatisticsDto().setDate("2022-09-21").setDeptName("字节").setProductName("抖音").setConsumption(new BigDecimal(60));
        processList.add(dto1);
        processList.add(dto2);
        processList.add(dto3);
        processList.add(dto4);
        processList.add(dto5);
        System.out.println("处理后前数据：" + JSON.toJSONString(processList));

        /**
         * 先对产品+时间合并分组后，合并每组数据为一条(消耗相加)，然后返回一个list(分组后size就是最终的返回size)
         */
        List<FinanceStatisticsDto> finalResult = processList.stream().collect(Collectors.groupingBy(x -> x.getProductName() + x.getDate())).values()
                .stream().flatMap(list -> Stream.of(list.stream().reduce((data1, data2) -> {
                    data1.setConsumption(data1.getConsumption().add(data2.getConsumption()));
                    return data1;
                }).orElse(new FinanceStatisticsDto()))).collect(Collectors.toList());

        System.out.println("处理后数据：" + JSON.toJSONString(finalResult));


        Set<String> collect = processList.stream().map(e -> e.getDeptName() + e.getProductName()).collect(Collectors.toSet());
        System.out.println("合并后数据：" + JSON.toJSONString(collect));

    }
}
