package com.zs6bvr.arduino.code.generator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;

@Service
public class CodeMakerServiceImpl implements CodeMakerService{
	
	
	private List<ProjectFeature> features;
	
	public CodeMakerServiceImpl() {}	



	@Override
	public BuildProjectResponse doBuildProject(BuildProjectResponse response) {


		StringBuilder finalCode=new StringBuilder();
		
		StringBuilder computerLanguages=new StringBuilder();
		StringBuilder microControllers=new StringBuilder();
		StringBuilder mcuPinsUsed=new StringBuilder("//");	
		
		StringBuilder contributor=new StringBuilder("//");
		
		StringBuilder contributorsNames=new StringBuilder();
		StringBuilder contributorsBlogPages=new StringBuilder();
		StringBuilder contributorsYoutubePages=new StringBuilder();
		
		StringBuilder descriptions=new StringBuilder();		
		StringBuilder prerequisites=new StringBuilder();
		
		StringBuilder featureNames=new StringBuilder();
		StringBuilder featureDecleration=new StringBuilder();
		StringBuilder featureAssignment=new StringBuilder();
		StringBuilder featurecode=new StringBuilder();
		StringBuilder featureStatus=new StringBuilder();
		


		
		
		List<UploadFeatureDto> features = response.getFeatures();
		if(features==null || features.size()<1) {
			response.setGeneratedCode(ResponseStatusCodes.SYSTEM_FAILURE.getResponseStatusCode());
			response.setResponseStatusMessage("No feastures were found for "+response.getProjectName());
			return response;
		}
		for (UploadFeatureDto uploadFeatureDto : features) {
			if(features!=null) {
				if(StringUtils.isNotEmpty(uploadFeatureDto.getMicroController())) {
					microControllers.append(uploadFeatureDto.getMicroController());
				}

				if(StringUtils.isNotEmpty(uploadFeatureDto.getComputerLanguage())) {
					computerLanguages.append(uploadFeatureDto.getComputerLanguage());
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getMcuPinsUsed())) {
					mcuPinsUsed.append(uploadFeatureDto.getMcuPinsUsed());
					mcuPinsUsed.append("\n");
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsName())) {
					contributor.append(uploadFeatureDto.getContributorsName());
					mcuPinsUsed.append("\n");			

					contributorsNames.append(uploadFeatureDto.getContributorsName());
					contributorsNames.append("\n");
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsBlogPage())) {
					contributor.append(uploadFeatureDto.getContributorsBlogPage());
					mcuPinsUsed.append("\n");
					

					contributorsBlogPages.append(uploadFeatureDto.getContributorsBlogPage());
					contributorsBlogPages.append("\n");
				}
				
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsYoutubePage())) {
					contributor.append(uploadFeatureDto.getContributorsYoutubePage());
					mcuPinsUsed.append("\n");
					
					contributorsYoutubePages.append(uploadFeatureDto.getContributorsYoutubePage());
					contributorsYoutubePages.append("\n");
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureName())) {
					contributor.append(uploadFeatureDto.getFeatureName());
					contributor.append("\n");		
					
					featureNames.append(uploadFeatureDto.getFeatureName());
					featureNames.append("\n");		
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getDescription())) {
					contributor.append(uploadFeatureDto.getDescription());
					contributor.append("\n");	
					
					descriptions.append(uploadFeatureDto.getDescription());
					descriptions.append("\n");	
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getPrerequisites())) {
					contributor.append(uploadFeatureDto.getPrerequisites());
					contributor.append("\n");	
					
					prerequisites.append(uploadFeatureDto.getPrerequisites());
					prerequisites.append("\n");	
				}
				
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureDecleration())) {
					featureDecleration.append(uploadFeatureDto.getFeatureDecleration());
					featureDecleration.append("\n");			
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureAssignment())) {
					featureAssignment.append(uploadFeatureDto.getFeatureAssignment());
					featureAssignment.append("\n");			
				}
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeaturecode())) {
					featurecode.append(uploadFeatureDto.getFeaturecode());
					featurecode.append("\n");				
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureStatus())) {
					featureStatus.append(uploadFeatureDto.getFeatureStatus());
					featureStatus.append("\n");				
				}
				

			}
		}		

		finalCode.append(contributor);
		finalCode.append(prerequisites);
		finalCode.append(mcuPinsUsed);
		finalCode.append(featureDecleration);
		finalCode.append(featureAssignment);
		finalCode.append(featurecode);
		finalCode.append(featureStatus);
		System.out.println(finalCode);
		response.setGeneratedCode(finalCode.toString());
		
		UploadFeatureDto jsonProjectExport=new UploadFeatureDto();

		jsonProjectExport.setContributorsName(contributorsNames.toString()); 
		jsonProjectExport.setContributorsBlogPage(contributorsBlogPages.toString()); 
		jsonProjectExport.setContributorsYoutubePage(contributorsYoutubePages.toString());

		jsonProjectExport.setComputerLanguage(computerLanguages.toString());
		jsonProjectExport.setMicroController(microControllers.toString());
		jsonProjectExport.setMcuPinsUsed(mcuPinsUsed.toString());  
		
		jsonProjectExport.setDescription(descriptions.toString());
		jsonProjectExport.setPrerequisites(prerequisites.toString());		

		jsonProjectExport.setFeatureName(featureNames.toString());
		jsonProjectExport.setFeatureDecleration(featureDecleration.toString());
		jsonProjectExport.setFeatureAssignment(featureAssignment.toString());
		jsonProjectExport.setFeaturecode(featurecode.toString());
		jsonProjectExport.setFeatureStatus(featureStatus.toString());
		
		response.setJsonProjectExport(jsonProjectExport);
		
		response.setResponseStatusCode(ResponseStatusCodes.OK.getResponseStatusCode());
		response.setResponseStatusMessage(ResponseStatusMessages.OK.getResponseStatusMessage());
		
		return response;
	}

	


}
