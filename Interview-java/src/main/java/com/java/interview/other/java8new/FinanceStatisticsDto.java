package com.java.interview.other.java8new;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 财务统计Dto
 * @author liaowenhui
 * @date 2022-09-22
 */
@Data
@Accessors(chain = true)
public class FinanceStatisticsDto implements Serializable {

    /**
     * 日期
     */
    private String date;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 公司
     */
    private String deptName;

    /**
     * 消耗
     */
    private BigDecimal consumption = new BigDecimal("0");

}
