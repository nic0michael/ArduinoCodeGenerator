package com.zs6bvr.arduino.code.generator.enums;

public enum ResponseStatusMessages {
	OK("OK : Code Generator operation succeeded "),
	BAD_REQUEST("The Request is NULL"),
	MQ_FAILURE("Failure : Failed to deliver Message to RabbitMQ"),
	JSON_FAILURE("Failure : Failed to conert DTO to a JSON String"),
	DATABASE_FAILURE("Failure : Failed to write to the Database"),
	MISSING_PROJECT_NAME("The Request is invalid : The project name is missing is missing"),
	MISSING_FIRST_MODULE("The Request is invalid : The first module is missing"),
	SYSTEM_FAILURE("Failure : a System failure occured"), 
	RESPONSE_NOT_SET_FAILURE("Expected response is null");
	
	
	
	String responseStatusMessage;
	
	private ResponseStatusMessages(String responseStatusMessage){
		this.responseStatusMessage=responseStatusMessage;
	}
	
	public String getResponseStatusMessage() {
		return this.responseStatusMessage;
	}

}
