package com.zs6bvr.arduino.code.generator.enums;

public enum ResponseStatusCodes {
	OK("200"),
	BAD_REQUEST("400"),
	MQ_FAILURE("401"),
	JSON_FAILURE("402"),
	DATABASE_FAILURE("403"),
	MISSING_PROJECT_NAME("404"),
	MISSING_FIRST_MODULE("405"),
	SYSTEM_FAILURE("411");
	
	String responseStatusCode;
	
	private ResponseStatusCodes(String responseStatusCode) {
		this.responseStatusCode=responseStatusCode;
	}
	public String getResponseStatusCode() {
		return this.responseStatusCode;
	}

}
