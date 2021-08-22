package com.zs6bvr.arduino.code.generator.validators;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;



@Component
public class RequestValidator {
	private static final Logger log = LoggerFactory.getLogger(RequestValidator.class);
	
	
//	BuildProjectResponse response=new BuildProjectResponse();
	

	private static final boolean VALIDATION_FAILED=false;
	private static final boolean VALIDATION_PASSED=true;
	
	private String responseStatusMessage;
	private String responseStatusCode;
	private BuildProjectResponse failedToSendToQueueResponse;
	
	public BuildProjectResponse validateBuildProjectRequest(BuildProjectRequest request) {
		log.info("validateSendToQueueRequest called");
		validateRequest(request);
		BuildProjectResponse response =makeSendToQueueResponse(request);
		log.info("validateSendToQueueRequest | response : "+response);
		return response;
	}

	private void validateRequest(BuildProjectRequest request) {
		log.info("validateRequest called");
		if(request==null) {
			responseStatusCode=ResponseStatusCodes.BAD_REQUEST.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.BAD_REQUEST.getResponseStatusMessage();
			
		} else if(StringUtils.isEmpty(request.getProjectName())) {
			responseStatusCode=ResponseStatusCodes.MISSING_PROJECT_NAME.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.MISSING_PROJECT_NAME.getResponseStatusMessage();
			
		}  else if(StringUtils.isEmpty(request.getFirstModule())) {
			responseStatusCode=ResponseStatusCodes.MISSING_FIRST_MODULE.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.MISSING_FIRST_MODULE.getResponseStatusMessage();
			
		}  else {
			responseStatusCode=ResponseStatusCodes.OK.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.OK.getResponseStatusMessage();
		}
		
	}
	


	private BuildProjectResponse makeSendToQueueResponse(BuildProjectRequest request) {
		BuildProjectResponse response=new BuildProjectResponse();
		response.setResponseStatusCode(responseStatusCode);
		response.setResponseStatusMessage(responseStatusMessage);
		return response;
	}
	

}
