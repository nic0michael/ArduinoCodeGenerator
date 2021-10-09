package com.zs6bvr.arduino.code.generator.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.ProjectType;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;

@Service
public class CodeMakerServiceImpl implements CodeMakerService{
	private static final Logger log = LoggerFactory.getLogger(CodeMakerServiceImpl.class);
	
	
	private List<ProjectFeature> features;
	
	public CodeMakerServiceImpl() {}	



	@Override
	public BuildProjectResponse doBuildProject(BuildProjectResponse response) {


		StringBuilder finalCode=new StringBuilder();
		
		StringBuilder computerLanguages=new StringBuilder();
		StringBuilder microControllers=new StringBuilder();
		StringBuilder mcuPinsUsed=new StringBuilder();	
		
		StringBuilder contributor=new StringBuilder();
		
		StringBuilder exportContributorsNames=new StringBuilder();
		StringBuilder exportContributorsBlogPages=new StringBuilder();
		StringBuilder exportContributorsYoutubePages=new StringBuilder();
		
		StringBuilder descriptions=new StringBuilder();		
		StringBuilder prerequisites=new StringBuilder();
		
		StringBuilder featureNames=new StringBuilder();
		StringBuilder featureClassImports=new StringBuilder();
		StringBuilder featureAssignment =new StringBuilder();
		StringBuilder featurecode =new StringBuilder();
		StringBuilder featureStatus=new StringBuilder();
		String projectType=null;


		
		
		List<UploadFeatureDto> features = response.getFeatures();
		if(features==null || features.size()<1) {
			response.setResponseStatusMessage(ResponseStatusMessages.SYSTEM_FAILURE.getResponseStatusMessage());
			response.setResponseStatusCode(ResponseStatusCodes.SYSTEM_FAILURE.getResponseStatusCode());
			return response;
		}
		for (UploadFeatureDto uploadFeatureDto : features) {
			if(features!=null) {
				if(StringUtils.isNotEmpty(uploadFeatureDto.getProjectType())) {
					projectType=uploadFeatureDto.getProjectType();
				}

				
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
					contributor.append("\n");			

					exportContributorsNames.append(uploadFeatureDto.getContributorsName());
					exportContributorsNames.append("\n");
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsBlogPage())) {
					contributor.append(uploadFeatureDto.getContributorsBlogPage());
					contributor.append("\n");
					

					exportContributorsBlogPages.append(uploadFeatureDto.getContributorsBlogPage());
					exportContributorsBlogPages.append("\n");
				}
				
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getContributorsYoutubePage())) {
					contributor.append(uploadFeatureDto.getContributorsYoutubePage());
					contributor.append("\n");
					
					exportContributorsYoutubePages.append(uploadFeatureDto.getContributorsYoutubePage());
					exportContributorsYoutubePages.append("\n");
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
				
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureClassImports())) {
					featureClassImports.append(uploadFeatureDto.getFeatureClassImports());
					featureClassImports.append("\n");	
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureAssignment())) {
					String cleanCode=cleanTheCode(uploadFeatureDto.getFeatureAssignment());
					featureAssignment.append(cleanCode);
					featureAssignment.append("\n");	
				}
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeaturecode())) {
					log.info("CodeMakerServiceImpl | doBuildProject | calling cleanTheCode called | "+uploadFeatureDto.getFeaturecode());
					String cleanCode=cleanTheCode(uploadFeatureDto.getFeaturecode());
					featurecode.append(cleanCode);
					featurecode.append("\n");	
				}
				
				if(StringUtils.isNotEmpty(uploadFeatureDto.getFeatureStatus())) {
					featureStatus.append(uploadFeatureDto.getFeatureStatus());
					featureStatus.append("\n");				
				}
				

			}
		}		

		finalCode.append("/*");
		finalCode.append("\n");
		finalCode.append("CONTRIBUTOR DETAILS:\n");
		finalCode.append(contributor.toString());
		finalCode.append("*/");
		finalCode.append("\n\n");

		finalCode.append("/*");
		finalCode.append("\n");
		finalCode.append("PREREQUISITES:\n");
		finalCode.append(prerequisites.toString());
		finalCode.append("*/");
		finalCode.append("\n\n");

		finalCode.append("/*");
		finalCode.append("\n");
		finalCode.append("MCU PINS USED:\n");
		finalCode.append(mcuPinsUsed.toString());
		finalCode.append("*/");
		finalCode.append("\n\n");		

		finalCode.append("/*");
		finalCode.append("\n");
		finalCode.append("FEATURE STATUS:\n");
		finalCode.append(featureStatus.toString());
		finalCode.append("*/");
		finalCode.append("\n\n");
		
		finalCode.append("/* FEATURE DECLERATION */\n");
		finalCode.append(featureClassImports);
		finalCode.append("\n\n");
		
		finalCode.append("/* FEATURE ASSIGNMENT */\n");
		if(ProjectType.ARDUINO_CPP.name().equalsIgnoreCase(projectType)) {
			finalCode.append("void setup() {\n");
		}
		finalCode.append(featureAssignment);
		if(ProjectType.ARDUINO_CPP.name().equalsIgnoreCase(projectType)) {
			finalCode.append("\n	}\n");
			finalCode.append("\n\n");
		}
		
		finalCode.append("/* FEATURE CODE */\n");
		if(ProjectType.ARDUINO_CPP.name().equalsIgnoreCase(projectType)) {
			finalCode.append("void loop() {\n");
		}
		finalCode.append(featurecode);
		if(ProjectType.ARDUINO_CPP.name().equalsIgnoreCase(projectType)) {
			finalCode.append("\n	}");
		}
		System.out.println(finalCode);
		response.setGeneratedCode(finalCode.toString());
		
		UploadFeatureDto jsonProjectExport=new UploadFeatureDto();
		
		jsonProjectExport.setProjectGUID("");
		jsonProjectExport.setContributorsName(exportContributorsNames.toString()); 
		jsonProjectExport.setContributorsBlogPage(exportContributorsBlogPages.toString()); 
		jsonProjectExport.setContributorsYoutubePage(exportContributorsYoutubePages.toString());

		jsonProjectExport.setComputerLanguage(computerLanguages.toString());
		jsonProjectExport.setMicroController(microControllers.toString());
		jsonProjectExport.setMcuPinsUsed(mcuPinsUsed.toString());  
		
		jsonProjectExport.setDescription(descriptions.toString());
		jsonProjectExport.setPrerequisites(prerequisites.toString());		

		jsonProjectExport.setFeatureName(featureNames.toString());
		jsonProjectExport.setFeatureClassImports(featureClassImports.toString());
		jsonProjectExport.setFeatureAssignment(featureAssignment.toString());
		jsonProjectExport.setFeaturecode(featurecode.toString());
		jsonProjectExport.setFeatureStatus(featureStatus.toString());
		
		response.setJsonProjectExport(jsonProjectExport);
		
		response.setResponseStatusCode(ResponseStatusCodes.OK.getResponseStatusCode());
		response.setResponseStatusMessage(ResponseStatusMessages.OK.getResponseStatusMessage());
		
		return response;
	}



	private String cleanTheCode(String featurecode) {
		log.info("CodeMakerServiceImpl | cleanTheCode called");
		StringBuilder code=new StringBuilder();	
		boolean asteriskFound=false;
		if(featurecode!=null && featurecode.length()>0) {
			int length=featurecode.length();
			for(int i=0;i<length;i++) {
				char ch=featurecode.charAt(i);
				code.append(ch);
				if(ch=='*') {
					log.info("CodeMakerServiceImpl | cleanTheCode | * found");
					asteriskFound=true;
				} else if(ch==';') {
					log.info("CodeMakerServiceImpl | cleanTheCode | ; found");
					code.append("\n");
					asteriskFound=false;
				} else if( ch=='/') {
					if(asteriskFound) {
						log.info("CodeMakerServiceImpl | cleanTheCode | */ found");
						code.append("\n");
					} else {
						log.info("CodeMakerServiceImpl | cleanTheCode | / found");
					}
					asteriskFound=false;
				} else {
					asteriskFound=false;
				}
			}
			log.info("CodeMakerServiceImpl | cleanTheCode | featurecode : \n"+featurecode);
		}else {
			code=new StringBuilder("");
		}
		
		return code.toString();
	}

	


}
