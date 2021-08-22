package com.zs6bvr.arduino.code.generator.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BuildProjectResponse")
public class BuildProjectResponse {

	String responseStatusCode;
	String responseStatusMessage;
	
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
		return "BuildProjectResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + "]";
	}
	
	

}
