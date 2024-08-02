package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

import java.math.BigDecimal;

public class CEOHandler implements Handler {

	@Override
	public Boolean process(Request request) {
		//如果费用大于5万，直接拒绝
		if (request.getAmount().compareTo(BigDecimal.valueOf(50000)) > 0) {
			return Boolean.FALSE;
		}
		//忽略大小写，如果赔偿金额大于10000不通过，赔太多了
		return !request.getName().equalsIgnoreCase("赔偿");
	}

	@Override
	public String getName() {
		return "CEO";
	}
}
