package com.zs6bvr.arduino.code.generator.business.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zs6bvr.arduino.code.generator.controllers.GeneratorController;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToWriteToatabaseException;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;
import com.zs6bvr.arduino.code.generator.validators.RequestValidator;

@Component
public class BusinessLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(BusinessLogicProcessor.class);

	@Autowired
	private RequestValidator validator;

	@Autowired
	private CodeMakerService service;

	@Autowired
	private DatabaseAdaptor database;

	public BusinessLogicProcessor() {
	}

	public BusinessLogicProcessor(RequestValidator validator, CodeMakerService service, DatabaseAdaptor database) {
		this.service = service;
		this.validator = validator;
		this.database=database;
	}

	public String getBuiltProject(BuildProjectRequest request) {
		String result=null;

		BuildProjectResponse response = validateRequest(request);
		if (!ResponseStatusCodes.OK.getResponseStatusCode().equalsIgnoreCase(response.getResponseStatusCode())) {
			log.error("BusinessLogicProcessor | doBuildProject | Validation failed");
			return response.getResponseStatusMessage();
		}
		
		try {
			response =database.getBuiltProject(request);
			response.setBuildProjectRequest(request);
		} catch (FailedToReadFromDatabaseException e) {
			e.printStackTrace();
			return ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		}
		result =doBuildProject(response);
		return result;
	}
	
	public String doBuildProject(BuildProjectResponse response) {
		String result = service.doBuildProject(response);
		log.debug("BusinessLogicProcessor | doBuildProject | result : " + result);
		return result;
	}
	
	public String processUploadData(String fileText, String persistProjectData) {
		return null;
	}
		
	public UploadFeatureResponse persistFeatureRecord(UploadFeatureRequest request) {
		UploadFeatureResponse response;

		try {
			response = database.persistFeatureRecord(request);
			log.debug("BusinessLogicProcessor | persistFeatureRecord | response : "
					+ response.getResponseStatusMessage());

		} catch (FailedToWriteToatabaseException e) {
			response = new UploadFeatureResponse();
			response.setResponseStatusCode(ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode());
			response.setResponseStatusMessage(ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage());
			log.error("BusinessLogicProcessor | persistFeatureRecord | Faided to write to Database", e);
		}
		return response;
	}

	public BuildProjectResponse validateRequest(BuildProjectRequest request) {
		return validator.validateBuildProjectRequest(request);
	}


}
