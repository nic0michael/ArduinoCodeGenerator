package com.zs6bvr.arduino.code.generator.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BuildProjectResponse")
public class BuildProjectResponse {

	private String responseStatusCode;
	private String responseStatusMessage;
	private String projectName;
	private String description;
	private List<UploadFeatureDto> features;
	private String generatedProjectCode;
	private String generatedCode;
	

	public void setBuildProjectRequest(BuildProjectRequest request) {
		projectName=request.getProjectName();
		description=request.getDescription();		
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
	public String getGeneratedProjectCode() {
		return generatedProjectCode;
	}
	public void setGeneratedProjectCode(String generatedProjectCode) {
		this.generatedProjectCode = generatedProjectCode;
	}



	@Override
	public String toString() {
		return "BuildProjectResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + ", projectName=" + projectName + ", description=" + description
				+ ", features=" + features + ", generatedProjectCode=" + generatedProjectCode + ", generatedCode="
				+ generatedCode + "]";
	}
	

	
	
	
	

}
