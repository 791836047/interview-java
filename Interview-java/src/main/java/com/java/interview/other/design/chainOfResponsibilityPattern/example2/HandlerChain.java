package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

	private List<Handler> handlers = new ArrayList<>();

	public void addHandler(Handler handler) {
		this.handlers.add(handler);
	}

	public boolean process(Request request) {
		for (Handler handler : handlers) {
			Boolean r = handler.process(request);
			if (r != null) {
				System.out.println(
						"项目:" + request.getName() +","+  "金额:" +  request.getAmount() + " " + (r ? "同意 by " : "拒绝 by ") + handler.getName());
				return r;
			}
		}
		throw new RuntimeException("Could not handle request: " + request);
	}

}
