package com.zs6bvr.arduino.code.generator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;

public class RequestResponseUtils {
	private static final Logger log = LoggerFactory.getLogger(RequestResponseUtils.class);

	public static UploadFeatureResponse makeSuccessUploadFeatureResponse() {
		UploadFeatureResponse response=new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);
		ProjectFeature projectFeature=makeSuccessProjectFeature();
		UploadFeatureDto uploadFeatureDto=makeUploadFeatureDto(projectFeature);
		List<UploadFeatureDto> uploadFeatureDtos=new ArrayList<UploadFeatureDto>();
		uploadFeatureDtos.add(uploadFeatureDto);
		response.setUploadFeatureDtos(uploadFeatureDtos);
		return response;
	}

	public static UploadFeatureResponse makeDatabaseFailedUploadFeatureResponse() {
		UploadFeatureResponse response=new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);		
		return response;
	}
	


	public static BuildProjectResponse makeSuccessBuildProjectResponse() {
		BuildProjectResponse response=new BuildProjectResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);
		UploadFeatureDto feature;
		ProjectFeature projectFeature;
		List<UploadFeatureDto> features=new ArrayList<>();
		projectFeature=makeSuccessProjectFeature();
		feature =makeUploadFeatureDto(projectFeature);
		features.add(feature);
		response.setFeatures(features);		
		return response;
	}

	public static BuildProjectResponse makeDatabaseFailedBuildProjectResponse() {
		BuildProjectResponse response=new BuildProjectResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);	
		
		return response;
	}


	public static UploadFeatureResponse makeFailedToPersistResponse() {
		UploadFeatureResponse response =new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);		
		return response;
	}

	public static UploadFeatureResponse makeSucceededToPersistResponse() {
		UploadFeatureResponse response =new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);		
		return response;
	}
	


	public static UploadFeatureResponse makeSucceededToPersistResponse(ProjectFeature resultantFeature) {
		UploadFeatureResponse response =new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);			
		
		UploadFeatureDto uploadFeatureDto=makeUploadFeatureDto(resultantFeature);
		List<UploadFeatureDto> uploadFeatureDtos=new ArrayList<UploadFeatureDto>();
		uploadFeatureDtos.add(uploadFeatureDto);
		response.setUploadFeatureDtos(uploadFeatureDtos);

		return response;
	}
	


	public static ProjectFeature makeProjectFeature(UploadFeatureRequest request) {
		ProjectFeature projectFeature=new ProjectFeature();
		projectFeature.setCategory(request.getCategory());
		projectFeature.setFeatureName(request.getFeatureName());
		projectFeature.setFeatureStatus(request.getFeatureStatus());
		projectFeature.setFeatureClassImports(request.getFeatureClassImports());
		projectFeature.setFeatureAssignment(request.getFeatureAssignment());
		projectFeature.setFeaturecode(request.getFeaturecode());
		projectFeature.setDescription(request.getDescription());
		projectFeature.setPrerequisites(request.getPrerequisites());
		projectFeature.setComputerLanguage(request.getComputerLanguage());
		projectFeature.setMicroController(request.getMicroController());
		projectFeature.setMcuPinsUsed(request.getMcuPinsUsed());
		projectFeature.setContributorsName(request.getContributorsName());
		projectFeature.setContributorsGuid(request.getContributorsGuid());
		projectFeature.setContributorsBlogPage(request.getContributorsBlogPage());
		projectFeature.setContributorsYoutubePage(request.getContributorsYoutubePage());
		projectFeature.setProjectType(request.getProjectType());
		log.info("RequestResponseUtils | makeProjectFeature | projectFeature : "+projectFeature);
		
		return projectFeature;
	}

	public static ProjectFeature makeSuccessProjectFeature() {
		ProjectFeature projectFeature=new ProjectFeature();
		projectFeature.setDescription("Dummydescription");
		projectFeature.setPrerequisites("Dummyprerequisites");
		projectFeature.setFeatureName("DummyfeatureName");
		projectFeature.setFeatureStatus("SUCCESS");
		projectFeature.setFeatureClassImports("DummyfeaturClassImports");
		projectFeature.setFeatureAssignment("DummyfeatureAssignment");
		projectFeature.setFeaturecode("Dummyfeaturecode");
		projectFeature.setComputerLanguage("DummycomputerLanguage");
		projectFeature.setMicroController("DummymicroController");
		projectFeature.setMcuPinsUsed("DummymcuPinsUsed");
		projectFeature.setContributorsName("DummycontributorsName");
		projectFeature.setContributorsBlogPage("DummycontributorsBlogPage");
		projectFeature.setContributorsYoutubePage("DummycontributorsYoutubePage");
		projectFeature.setProjectType("DummyProjectType");
		
		return projectFeature;
	}


	public static UploadFeatureDto makeUploadFeatureDto(ProjectFeature projectFeature) {
		UploadFeatureDto uploadFeatureDto=new UploadFeatureDto();

		uploadFeatureDto.setCategory(projectFeature.getCategory());
		uploadFeatureDto.setProjectGUID(projectFeature.getProjectGUID());
		uploadFeatureDto.setDescription(projectFeature.getDescription());
		uploadFeatureDto.setPrerequisites(projectFeature.getPrerequisites());
		uploadFeatureDto.setFeatureName(projectFeature.getFeatureName());
		uploadFeatureDto.setFeatureStatus(projectFeature.getFeatureStatus());
		uploadFeatureDto.setFeatureClassImports(projectFeature.getFeatureClassImports());
		uploadFeatureDto.setFeatureAssignment(projectFeature.getFeatureAssignment());
		uploadFeatureDto.setFeaturecode(projectFeature.getFeaturecode());
		uploadFeatureDto.setComputerLanguage(projectFeature.getComputerLanguage());
		uploadFeatureDto.setMicroController(projectFeature.getMicroController());
		uploadFeatureDto.setMcuPinsUsed(projectFeature.getMcuPinsUsed());
		uploadFeatureDto.setContributorsName(projectFeature.getContributorsName());
		uploadFeatureDto.setContributorsGuid(projectFeature.getContributorsGuid());
		uploadFeatureDto.setContributorsBlogPage(projectFeature.getContributorsBlogPage());
		uploadFeatureDto.setContributorsYoutubePage(projectFeature.getContributorsYoutubePage());
		uploadFeatureDto.setProjectType(projectFeature.getProjectType());
		return uploadFeatureDto;
	}

	public static UploadFeatureRequest makeUploadFeatureRequest() {
		// TODO Auto-generated method stub
		return null;
	}
	


	public static  BuildProjectRequest makeBadBuildProjectRequest() {
		BuildProjectRequest request = makeBuildProjectRequest();
		request.setProjectName(null);
		return request;
	}

	public static  BuildProjectRequest makeBuildProjectRequest() {
		BuildProjectRequest request = new BuildProjectRequest();
		request.setProjectName("ProjectName");
		request.setFirstModule("FirstModule");
		return request;
	}

	public static List<UploadFeatureDto> makeUploadFeatureDtos(List<ProjectFeature> projectFeatures) {
		List<UploadFeatureDto> uploadFeatureDtos =new ArrayList<UploadFeatureDto>();
		for (ProjectFeature projectFeature : projectFeatures) {
			if(projectFeature!=null) {
				UploadFeatureDto uploadFeatureDto=makeUploadFeatureDto(projectFeature);
				uploadFeatureDtos.add(uploadFeatureDto);
			}
		}
		
		return uploadFeatureDtos;
	}

	public static ProjectFeature makeProjectFeature(UploadFeatureDto uploadFeatureDto) {
		ProjectFeature feature =new ProjectFeature();
		return setProjectFeature(feature, uploadFeatureDto);
	}

	public static ProjectFeature setProjectFeature(ProjectFeature feature, UploadFeatureDto uploadFeatureDto) {
		String OTHER_CATEGORY="otherCategory";

		feature.setFeatureName(  uploadFeatureDto.getFeatureName());
		feature.setFeatureStatus(  uploadFeatureDto.getFeatureStatus());
		feature.setProjectType(  uploadFeatureDto.getProjectType());
		feature.setFeatureClassImports(  uploadFeatureDto.getFeatureClassImports());
		feature.setFeatureAssignment(  uploadFeatureDto.getFeatureAssignment());
		feature.setFeaturecode(  uploadFeatureDto.getFeaturecode());
		feature.setDescription(  uploadFeatureDto.getDescription());
	
		if(OTHER_CATEGORY.equalsIgnoreCase(uploadFeatureDto.getCategory()) && StringUtils.isNotEmpty(uploadFeatureDto.getOtherCategory())) {
			feature.setCategory( uploadFeatureDto.getOtherCategory());
		} else {
			feature.setCategory(  uploadFeatureDto.getCategory());
		}
		feature.setPrerequisites(  uploadFeatureDto.getPrerequisites());
		feature.setComputerLanguage(  uploadFeatureDto.getComputerLanguage());
		feature.setMicroController(  uploadFeatureDto.getMicroController());
		feature.setMcuPinsUsed(  uploadFeatureDto.getMcuPinsUsed());
		feature.setContributorsName(  uploadFeatureDto.getContributorsName());
		feature.setContributorsGuid(  uploadFeatureDto.getContributorsGuid());
		feature.setContributorsBlogPage(  uploadFeatureDto.getContributorsBlogPage());
		feature.setContributorsYoutubePage(  uploadFeatureDto.getContributorsYoutubePage());		

		return feature;
	}



}
