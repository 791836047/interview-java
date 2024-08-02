package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

import java.math.BigDecimal;

public class DirectorHandler implements Handler {

	@Override
	public Boolean process(Request request) {
		//如果费用超过10000，得CEO以上的审批
		if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
			return null;
		}
		//如果是出差报销大于5000的话不同意
		return !request.getName().equalsIgnoreCase("出差报销");
	}

	@Override
	public String getName() {
		return "主任";
	}
}
