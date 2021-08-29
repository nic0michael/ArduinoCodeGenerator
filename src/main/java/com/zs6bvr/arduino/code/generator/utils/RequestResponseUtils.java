package com.zs6bvr.arduino.code.generator.utils;

import java.util.ArrayList;
import java.util.List;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;

public class RequestResponseUtils {

	public static UploadFeatureResponse makeSuccessUploadFeatureResponse() {
		UploadFeatureResponse response=new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		response.setResponseStatusCode(expectedResponseStatusCode);
		response.setResponseStatusMessage(expectedResponseStatusMessage);		
		return response;
	}

	public static UploadFeatureResponse makeDatabaseFailedUploadFeatureResponse() {
		UploadFeatureResponse response=new UploadFeatureResponse();
		String expectedResponseStatusCode = ResponseStatusCodes.SYSTEM_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.SYSTEM_FAILURE.getResponseStatusMessage();
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

	public static ProjectFeature makeSuccessProjectFeature() {
		ProjectFeature projectFeature=new ProjectFeature();
		
		projectFeature.setProjectGUID("DummyprojectGUID");
		projectFeature.setDescription("Dummydescription");
		projectFeature.setPrerequisites("Dummyprerequisites");
		projectFeature.setFeatureName("DummyfeatureName");
		projectFeature.setFeatureStatus("SUCCESS");
		projectFeature.setFeatureDecleration("DummyfeatureDecleration");
		projectFeature.setFeatureAssignment("DummyfeatureAssignment");
		projectFeature.setFeaturecode("Dummyfeaturecode");
		projectFeature.setComputerLanguage("DummycomputerLanguage");
		projectFeature.setMicroController("DummymicroController");
		projectFeature.setMcuPinsUsed("DummymcuPinsUsed");
		projectFeature.setContributorsName("DummycontributorsName");
		projectFeature.setContributorsBlogPage("DummycontributorsBlogPage");
		projectFeature.setContributorsYoutubePage("DummycontributorsYoutubePage");
		
		return projectFeature;
	}


	private static UploadFeatureDto makeUploadFeatureDto(ProjectFeature projectFeature) {
		UploadFeatureDto uploadFeatureDto=new UploadFeatureDto();

		uploadFeatureDto.setProjectGUID(projectFeature.getProjectGUID());
		uploadFeatureDto.setDescription(projectFeature.getDescription());
		uploadFeatureDto.setPrerequisites(projectFeature.getPrerequisites());
		uploadFeatureDto.setFeatureName(projectFeature.getFeatureName());
		uploadFeatureDto.setFeatureStatus(projectFeature.getFeatureStatus());
		uploadFeatureDto.setFeatureDecleration(projectFeature.getFeatureDecleration());
		uploadFeatureDto.setFeatureAssignment(projectFeature.getFeatureAssignment());
		uploadFeatureDto.setFeaturecode(projectFeature.getFeaturecode());
		uploadFeatureDto.setComputerLanguage(projectFeature.getComputerLanguage());
		uploadFeatureDto.setMicroController(projectFeature.getMicroController());
		uploadFeatureDto.setMcuPinsUsed(projectFeature.getMcuPinsUsed());
		uploadFeatureDto.setContributorsName(projectFeature.getContributorsName());
		uploadFeatureDto.setContributorsBlogPage(projectFeature.getContributorsBlogPage());
		uploadFeatureDto.setContributorsYoutubePage(projectFeature.getContributorsYoutubePage());
		return uploadFeatureDto;
	}
	
	public static ProjectFeature makeFailedProjectFeature() {
		ProjectFeature projectFeature=new ProjectFeature();
		projectFeature.setFeatureStatus("FAILED");
		return projectFeature;
	}

}
