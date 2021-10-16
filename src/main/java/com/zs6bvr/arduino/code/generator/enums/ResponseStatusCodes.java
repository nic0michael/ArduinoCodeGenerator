package com.zs6bvr.arduino.code.generator.enums;

public enum ResponseStatusCodes {
	OK("200"),
	BAD_REQUEST("400"),
	MQ_FAILURE("401"),
	JSON_FAILURE("402"),
	DATABASE_FAILURE("403"),
	MISSING_PROJECT_NAME("404"),
	MISSING_FIRST_MODULE("405"),
	SYSTEM_FAILURE("406"), 
	RESPONSE_NOT_SET_FAILURE("407"),
	MISSING_FEATURE_NAME("408"),
	MISSING_DESCRIPTION("409"),
	MISSING_PROJECT_TYPE("410"),
	MISSING_MCU_PINS_USED("411"),
	MISSING_MICRO_CONTROLLER_USED("412"),
	MISSING_FEATURE_CODE("413"),
	MISSING_COMPUTER_LANGUAGE("414"),
	MISSING_PROJECT_CATEGORY("415");
	
	String responseStatusCode;
	
	private ResponseStatusCodes(String responseStatusCode) {
		this.responseStatusCode=responseStatusCode;
	}
	public String getResponseStatusCode() {
		return this.responseStatusCode;
	}

}
