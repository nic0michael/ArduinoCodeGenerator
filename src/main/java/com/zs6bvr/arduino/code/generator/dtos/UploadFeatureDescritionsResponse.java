package com.zs6bvr.arduino.code.generator.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UploadFeatureDescritionsResponse")
public class UploadFeatureDescritionsResponse {
	private String responseStatusCode;
	private String responseStatusMessage;
	private List<FeatureDescriptionDTO>featureDescriptions;
	
	public UploadFeatureDescritionsResponse(){}

	public UploadFeatureDescritionsResponse(String responseStatusCode, String responseStatusMessage,
			List<FeatureDescriptionDTO> festureDescriptions) {
		super();
		this.responseStatusCode = responseStatusCode;
		this.responseStatusMessage = responseStatusMessage;
		this.featureDescriptions = festureDescriptions;
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

	public List<FeatureDescriptionDTO> getFeatureDescriptions() {
		return featureDescriptions;
	}

	public void setFeatureDescriptions(List<FeatureDescriptionDTO> festureDescriptions) {
		this.featureDescriptions = festureDescriptions;
	}

	@Override
	public String toString() {
		return "UploadFeatureDescritionsResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + ", festureDescriptions=" + featureDescriptions + "]";
	}
	
}
