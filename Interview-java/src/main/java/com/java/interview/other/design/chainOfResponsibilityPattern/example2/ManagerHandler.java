package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

import java.math.BigDecimal;

public class ManagerHandler implements Handler {

	@Override
	public Boolean process(Request request) {
		BigDecimal amount = request.getAmount();
		String name = request.getName();
		//如果费用超过1000，得主任以上的审批
		if (amount.compareTo(BigDecimal.valueOf(5000)) > 0) {
			return null;
		}
		//团建费用如果大于2000，则不同意
		if (name.equalsIgnoreCase("团建") && amount.compareTo(BigDecimal.valueOf(2000)) >= 0){
			return false;

		}
		//小于5000的别的费用可以通过
		return true;
	}

	@Override
	public String getName() {
		return "经理";
	}
}
