package com.java.interview.other.design.chainOfResponsibilityPattern.example2;

public interface Handler {

	Boolean process(Request request);

	String getName();

}
