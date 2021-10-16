package com.zs6bvr.arduino.code.generator.validators;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;



@Component
public class RequestValidator {
	private static final Logger log = LoggerFactory.getLogger(RequestValidator.class);
	
	
//	BuildProjectResponse response=new BuildProjectResponse();
	

	private static final boolean VALIDATION_FAILED=false;
	private static final boolean VALIDATION_PASSED=true;
	
	private String responseStatusMessage,responseStatusMessage2;
	private String responseStatusCode,responseStatusCode2;
	private BuildProjectResponse failedToBuildProjectResponse;
	private UploadFeatureResponse failedToUploadFeatureResponse;
	
	public BuildProjectResponse validateBuildProjectRequest(BuildProjectRequest request) {
		log.info("validateBuildProjectRequest called");
		validateRequest(request);
		BuildProjectResponse response =makeSendToQueueResponse(request);
		log.info("validateBuildProjectRequest | response : "+response);
		return response;
	}
	
	public UploadFeatureResponse validateUploadFeatureRequest(UploadFeatureRequest request) {
		log.info("validateUploadFeatureRequest called");
		validateRequest(request);
		UploadFeatureResponse response =makeUploadFeatureResponse(request);
		log.info("validateUploadFeatureRequest | response : "+response);
		return response;
		
	}
	


	private void validateRequest(UploadFeatureRequest request) {
		if(request==null) {
			responseStatusCode2=ResponseStatusCodes.BAD_REQUEST.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.BAD_REQUEST.getResponseStatusMessage();
			
		} else if(StringUtils.isEmpty(request.getFeatureName())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_FEATURE_NAME.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_FEATURE_NAME.getResponseStatusMessage();
			
		}  else if(StringUtils.isEmpty(request.getDescription())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_DESCRIPTION.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_DESCRIPTION.getResponseStatusMessage();
			
		}   else if(StringUtils.isEmpty(request.getProjectType())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_PROJECT_TYPE.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_PROJECT_TYPE.getResponseStatusMessage();
			
		}   else if(StringUtils.isEmpty(request.getMcuPinsUsed())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_MCU_PINS_USED.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_MCU_PINS_USED.getResponseStatusMessage();
			
		}    else if(StringUtils.isEmpty(request.getMicroController())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_MICRO_CONTROLLER_USED.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_MICRO_CONTROLLER_USED.getResponseStatusMessage();
			
		}   else if(StringUtils.isEmpty(request.getFeaturecode())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_FEATURE_CODE.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_FEATURE_CODE.getResponseStatusMessage();
			
		}   else if(StringUtils.isEmpty(request.getComputerLanguage())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_COMPUTER_LANGUAGE.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_COMPUTER_LANGUAGE.getResponseStatusMessage();
			
		}   else if(StringUtils.isEmpty(request.getCategory())) {
			responseStatusCode2=ResponseStatusCodes.MISSING_PROJECT_CATEGORY.getResponseStatusCode();
			responseStatusMessage2=ResponseStatusMessages.MISSING_PROJECT_CATEGORY.getResponseStatusMessage();
			
		} 
		
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
	
	private UploadFeatureResponse makeUploadFeatureResponse(UploadFeatureRequest request) {
		UploadFeatureResponse response =new UploadFeatureResponse();
		response.setResponseStatusCode(responseStatusCode2);
		response.setResponseStatusMessage(responseStatusMessage2);
		return response;
	}


	private BuildProjectResponse makeSendToQueueResponse(BuildProjectRequest request) {
		BuildProjectResponse response=new BuildProjectResponse();
		response.setResponseStatusCode(responseStatusCode);
		response.setResponseStatusMessage(responseStatusMessage);
		return response;
	}
	

}
