package com.zs6bvr.arduino.code.generator.dtos;

import java.util.Date;

public class CreateContributorRequest {

	private Long contributorsId;

	private Date dateCreated;

	private String contributorsGuid;

	private String contributorsName;

	private String contributorsBlogPage;

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
		return "CreateContributorRequest [contributorsId=" + contributorsId + ", dateCreated=" + dateCreated
				+ ", contributorsGuid=" + contributorsGuid + ", contributorsName=" + contributorsName
				+ ", contributorsBlogPage=" + contributorsBlogPage + "]";
	}
	
	

}
