package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

import java.math.BigDecimal;

public class Request {
	//报销项目
	private String name;
	//报销金额
	private BigDecimal amount;

	public Request(String name, BigDecimal amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return String.format("{Request: name=%s, amount=%s}", name, amount);
	}
}
