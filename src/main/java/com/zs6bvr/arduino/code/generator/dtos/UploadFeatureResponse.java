package com.zs6bvr.arduino.code.generator.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BuildProjectResponse")
public class UploadFeatureResponse {

	String responseStatusCode;
	String responseStatusMessage;
	List<UploadFeatureDto>uploadFeatureDtos;
	
	public UploadFeatureResponse() {}
	
	
	
	public UploadFeatureResponse(String responseStatusCode, String responseStatusMessage,
			List<UploadFeatureDto> uploadFeatureDtos) {
		super();
		this.responseStatusCode = responseStatusCode;
		this.responseStatusMessage = responseStatusMessage;
		this.uploadFeatureDtos = uploadFeatureDtos;
	}



	public List<UploadFeatureDto> getUploadFeatureDtos() {
		return uploadFeatureDtos;
	}



	public void setUploadFeatureDtos(List<UploadFeatureDto> uploadFeatureDtos) {
		this.uploadFeatureDtos = uploadFeatureDtos;
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



	@Override
	public String toString() {
		return "UploadFeatureResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + ", uploadFeatureDtos=" + uploadFeatureDtos + "]";
	}


	
	

}
