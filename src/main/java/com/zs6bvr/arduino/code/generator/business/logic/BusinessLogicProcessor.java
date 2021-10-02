package com.zs6bvr.arduino.code.generator.business.logic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zs6bvr.arduino.code.generator.controllers.GeneratorController;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.FeatureDescriptionDTO;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDescritionsResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
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

	public String generateProjectCode(BuildProjectRequest request) {
		log.debug("BusinessLogicProcessor | generateProjectCode | request : " + request);
		String generatedProjectCode="No Data Received from database";
		BuildProjectResponse response = doBuildProjectResponse(request);
		if(response!=null) {
			log.info("BusinessLogicProcessor | generateProjectCode | response : "+response);
			if(ResponseStatusCodes.OK.getResponseStatusCode().equalsIgnoreCase(response.getResponseStatusCode())){
				generatedProjectCode =response.getGeneratedCode();
			} else {
				generatedProjectCode=response.getResponseStatusMessage();
			}
		}
		return generatedProjectCode;
	}
	

	public BuildProjectResponse getExportedProject(BuildProjectRequest request) {
		log.debug("BusinessLogicProcessor | getExportedProject | request : " + request);
		BuildProjectResponse response = doBuildProjectResponse(request);
		response.setGeneratedCode("Please note exporting a project does not generate the code");
		return response;
	}

	
	private BuildProjectResponse doBuildProjectResponse(BuildProjectRequest request) {

		BuildProjectResponse response = validateRequest(request);
		
		if (!ResponseStatusCodes.OK.getResponseStatusCode().equalsIgnoreCase(response.getResponseStatusCode())) {
			log.error("BusinessLogicProcessor | doBuildProject | Validation failed");
			return response;
		}
		
		try {
			response =database.getBuiltProject(request);
			if(response!=null) {
				response.setBuildProjectRequest(request);
			}
		} catch (FailedToReadFromDatabaseException e) {
			log.error("BusinessLogicProcessor | generateProject failed ",e);
			response.setResponseStatusMessage(ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage());
			response.setResponseStatusCode(ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode());
			return response;
		}
		
		response=service.doBuildProject(response);
		log.debug("BusinessLogicProcessor | doBuildProjectResponse | generatedResponse : " + response);		
		return response;
	}
	
	public String processUploadData(String fileText, String persistProjectData) {
		return null;
	}
		
	public UploadFeatureResponse saveFeature(UploadFeatureRequest request) {
		UploadFeatureResponse response;

		try {
			response = database.insertFeatureRecord(request);
			if(response!=null) {
				log.debug("BusinessLogicProcessor | persistFeatureRecord | response : "	+ response.getResponseStatusMessage());
			} else {
				log.debug("BusinessLogicProcessor | persistFeatureRecord | response is empty");
				response = new UploadFeatureResponse();
				response.setResponseStatusCode(ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode());
				response.setResponseStatusMessage(ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage());
			}

		} catch (FailedToWriteToatabaseException e) {
			response = new UploadFeatureResponse();
			response.setResponseStatusCode(ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode());
			response.setResponseStatusMessage(ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage());
			log.error("BusinessLogicProcessor | persistFeatureRecord | Faided to write to Database", e);
		}
		return response;
	}


	public UploadFeatureDescritionsResponse getDescriptionsOfAllFeatures() {
		UploadFeatureDescritionsResponse response=new UploadFeatureDescritionsResponse();
		UploadFeatureResponse uploadFeatureResponse=getAllFeatures();
		if(uploadFeatureResponse==null) {
			response.setResponseStatusCode(ResponseStatusCodes.RESPONSE_NOT_SET_FAILURE.getResponseStatusCode());
			response.setResponseStatusMessage(ResponseStatusMessages.RESPONSE_NOT_SET_FAILURE.getResponseStatusMessage());
			
		} else {
			response.setResponseStatusCode(ResponseStatusCodes.OK.getResponseStatusCode());
			response.setResponseStatusMessage(ResponseStatusMessages.OK.getResponseStatusMessage());
			List<FeatureDescriptionDTO> featureDescriptions=new ArrayList<FeatureDescriptionDTO>();
			List<UploadFeatureDto> uploadFeatureDtos = uploadFeatureResponse.getUploadFeatureDtos();
			FeatureDescriptionDTO featureDescriptionDTO=null;
			
			for (UploadFeatureDto uploadFeatureDto : uploadFeatureDtos) {
				if(uploadFeatureDto!=null) {
					featureDescriptionDTO=new FeatureDescriptionDTO();
					featureDescriptionDTO.setFeatureDescriptionDTO(uploadFeatureDto);
					featureDescriptions.add(featureDescriptionDTO);
				}
			}
			
			response.setFeatureDescriptions(featureDescriptions);
		}
			return response;

	}

	public BuildProjectResponse validateRequest(BuildProjectRequest request) {
		return validator.validateBuildProjectRequest(request);
	}

	public UploadFeatureResponse getAllFeatures() {
		return database.getAllFeatures();
	}

	public UploadFeatureResponse getFeature(String projectGUID) {
		return database.getFeature(projectGUID);
	}

	public UploadFeatureResponse getFeature(Long id) {
		return database.getFeature(id);
	}

	public UploadFeatureResponse updateFeature(Long id, UploadFeatureRequest request) {
		return database.updateFeature(id, request);
	}



}
