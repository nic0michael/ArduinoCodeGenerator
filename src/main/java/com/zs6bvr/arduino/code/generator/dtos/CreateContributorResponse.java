package com.zs6bvr.arduino.code.generator.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

public class CreateContributorResponse {
	String responseStatusCode;
	String responseStatusMessage;
	
	private Long contributorsId;

	private Date dateCreated;

	private String contributorsGuid;

	private String contributorsName;

	private String contributorsBlogPage;
	
	private String contributorsYoutubePage;
	
	

	public String getContributorsYoutubePage() {
		return contributorsYoutubePage;
	}

	public void setContributorsYoutubePage(String contributorsYoutubePage) {
		this.contributorsYoutubePage = contributorsYoutubePage;
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

	public Long getContributorsId() {
		return contributorsId;
	}

	public void setContributorsId(Long contributorsId) {
		this.contributorsId = contributorsId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getContributorsGuid() {
		return contributorsGuid;
	}

	public void setContributorsGuid(String contributorsGuid) {
		this.contributorsGuid = contributorsGuid;
	}

	public String getContributorsName() {
		return contributorsName;
	}

	public void setContributorsName(String contributorsName) {
		this.contributorsName = contributorsName;
	}

	public String getContributorsBlogPage() {
		return contributorsBlogPage;
	}

	public void setContributorsBlogPage(String contributorsBlogPage) {
		this.contributorsBlogPage = contributorsBlogPage;
	}

	@Override
	public String toString() {
		return "CreateContributorResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + ", contributorsId=" + contributorsId + ", dateCreated=" + dateCreated
				+ ", contributorsGuid=" + contributorsGuid + ", contributorsName=" + contributorsName
				+ ", contributorsBlogPage=" + contributorsBlogPage + ", contributorsYoutubePage="
				+ contributorsYoutubePage + "]";
	}




}
