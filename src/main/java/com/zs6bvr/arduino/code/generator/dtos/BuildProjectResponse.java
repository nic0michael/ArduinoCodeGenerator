package com.zs6bvr.arduino.code.generator.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

@XmlRootElement(name = "BuildProjectResponse")
public class BuildProjectResponse {

	private String responseStatusCode;
	private String responseStatusMessage;
	private String projectName;
	private String description;		
	private String category;
	private List<UploadFeatureDto> features;
	private String generatedCode;
	private UploadFeatureDto jsonProjectExport;
	private String projectType;
	

	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getProjectType() {
		return projectType;
	}



	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}



	public void setBuildProjectRequest(BuildProjectRequest request) {
		if(StringUtils.isNotEmpty(request.getProjectName())) {
			projectName=request.getProjectName();
		}
		if(StringUtils.isNotEmpty(request.getDescription())) {
			description=request.getDescription();		
		}
	}
	
	
	
	public UploadFeatureDto getJsonProjectExport() {
		return jsonProjectExport;
	}



	public void setJsonProjectExport(UploadFeatureDto jsonProjectExport) {
		this.jsonProjectExport = jsonProjectExport;
	}



	public String getGeneratedCode() {
		return generatedCode;
	}



	public void setGeneratedCode(String generatedCode) {
		this.generatedCode = generatedCode;
	}



	public String getResponseStatusCode() {
		return responseStatusCode;
	}
	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	public String getResponseStatusMessage() {
		return responseStatusMessage;
	}
	public void setResponseStatusMessage(String responseStatusMessage) {
		this.responseStatusMessage = responseStatusMessage;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UploadFeatureDto> getFeatures() {
		return features;
	}
	public void setFeatures(List<UploadFeatureDto> features) {
		this.features = features;
	}



	@Override
	public String toString() {
		return "BuildProjectResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + ", projectName=" + projectName + ", description=" + description
				+ ", category=" + category + ", features=" + features + ", generatedCode=" + generatedCode
				+ ", jsonProjectExport=" + jsonProjectExport + ", projectType=" + projectType + "]";
	}







	



	

	
	
	
	

}
