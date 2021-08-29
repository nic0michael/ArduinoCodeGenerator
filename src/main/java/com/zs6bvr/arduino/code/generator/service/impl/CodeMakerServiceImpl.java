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
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;

@Service
public class CodeMakerServiceImpl implements CodeMakerService{
	
	
	private List<ProjectFeature> features;
	
	public CodeMakerServiceImpl() {}	



	@Override
	public String doBuildProject(BuildProjectResponse response) {


		StringBuilder finalCode=new StringBuilder();
		
		StringBuilder mcuPinsUsed=new StringBuilder();	
		StringBuilder contributor=new StringBuilder();
		StringBuilder prerequisites=new StringBuilder();	
		StringBuilder featureDecleration=new StringBuilder();
		StringBuilder featureAssignment=new StringBuilder();
		StringBuilder featurecode=new StringBuilder();
		StringBuilder featureStatus=new StringBuilder();
		


		
		
		List<UploadFeatureDto> features = response.getFeatures();
		if(features==null || features.size()<1) {
			return "No feastures were found for "+response.getProjectName();
		}
		for (UploadFeatureDto uploadFeatureDto : features) {
			if(features!=null) {
				if(StringUtils.isNotEmpty(uploadFeatureDto.getMcuPinsUsed())) {
					mcuPinsUsed.append(uploadFeatureDto.getMcuPinsUsed());
					mcuPinsUsed.append("\n//=======================//\n");
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsName())) {
					contributor.append(uploadFeatureDto.getContributorsName());
					contributor.append("\n//=======================//\n");
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsBlogPage())) {
					contributor.append(uploadFeatureDto.getContributorsBlogPage());
					contributor.append("\n//=======================//\n");					
				}
				
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsYoutubePage())) {
					contributor.append(uploadFeatureDto.getContributorsYoutubePage());
					contributor.append("\n//=======================//\n");					
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureName())) {
					contributor.append(uploadFeatureDto.getFeatureName());
					contributor.append("\n//=======================//\n");					
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getDescription())) {
					contributor.append(uploadFeatureDto.getDescription());
					contributor.append("\n//=======================//\n");					
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getPrerequisites())) {
					contributor.append(uploadFeatureDto.getPrerequisites());
					contributor.append("\n//=======================//\n");					
				}
				
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureDecleration())) {
					featureDecleration.append(uploadFeatureDto.getFeatureDecleration());
					featureDecleration.append("\n//=======================//\n");					
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureAssignment())) {
					featureAssignment.append(uploadFeatureDto.getFeatureAssignment());
					featureAssignment.append("\n//=======================//\n");					
				}
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeaturecode())) {
					featurecode.append(uploadFeatureDto.getFeaturecode());
					featurecode.append("\n//=======================//\n");					
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureStatus())) {
					featureStatus.append(uploadFeatureDto.getFeatureStatus());
					featureStatus.append("\n//=======================//\n");					
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
		
		return finalCode.toString();
	}

	


}
