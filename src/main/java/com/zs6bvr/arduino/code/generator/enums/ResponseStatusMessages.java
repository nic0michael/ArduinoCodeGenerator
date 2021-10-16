package com.zs6bvr.arduino.code.generator.enums;

public enum ResponseStatusMessages {
	OK("OK : Code Generator operation succeeded "),
	BAD_REQUEST("The Request is NULL"),
	MQ_FAILURE("Failure : Failed to deliver Message to RabbitMQ"),
	JSON_FAILURE("Failure : Failed to conert DTO to a JSON String"),
	DATABASE_FAILURE("Failure : Failed to write to the Database"),
	MISSING_PROJECT_NAME("The Request is invalid : The project name is missing"),
	MISSING_FIRST_MODULE("The Request is invalid : The first module is missing"),
	SYSTEM_FAILURE("Failure : a System failure occured"), 
	RESPONSE_NOT_SET_FAILURE("Expected response is null"),
	MISSING_FEATURE_NAME("The Request is invalid : The feature name is missing"),
	MISSING_DESCRIPTION("The Request is invalid : The description is missing"),
	MISSING_PROJECT_TYPE("The Request is invalid : The project type is missing"),
	MISSING_MCU_PINS_USED("The Request is invalid : The MCU pins used field is missing"),
	MISSING_MICRO_CONTROLLER_USED("The Request is invalid : The Microcontroller used is missing"),
	MISSING_FEATURE_CODE("The Request is invalid : The program Code is missing"),
	MISSING_COMPUTER_LANGUAGE("The Request is invalid : The program Language is missing"),
	MISSING_PROJECT_CATEGORY("The Request is invalid : The project category is missing");
	
	
	
	String responseStatusMessage;
	
	private ResponseStatusMessages(String responseStatusMessage){
		this.responseStatusMessage=responseStatusMessage;
	}
	
	public String getResponseStatusMessage() {
		return this.responseStatusMessage;
	}

}
