package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

import java.math.BigDecimal;

/**
 * 示例
 */
public class ApplicationDemo {
    /**
     * 在实际场景中，财务审批就是一个责任链模式。假设某个员工需要报销一笔费用，审核者可以分为：
     *
     * Manager：只能审核1000元以下的报销；
     * Director：只能审核10000元以下的报销；
     * CEO：可以审核任意额度。
     * @param args
     */
    public static void main(String[] args) {
        // 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());

        System.out.println("财务审批：  ");
        //团建费用不能超过2000
        chain.process(new Request("团建", new BigDecimal("1000")));
        chain.process(new Request("团建", new BigDecimal("2000")));
        //出差报销不能大于5000
        chain.process(new Request("出差报销", new BigDecimal("3000")));
        chain.process(new Request("出差报销", new BigDecimal("6000")));
        //赔偿金额不能大于10000
        chain.process(new Request("赔偿", new BigDecimal("8000")));
        chain.process(new Request("赔偿", new BigDecimal("20000")));
        //费用超过5万的，直接拒绝
        chain.process(new Request("员工奖金", new BigDecimal("40000")));
        chain.process(new Request("员工奖金", new BigDecimal("60000")));
    }
}
