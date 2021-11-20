package com.zs6bvr.arduino.code.generator.dtos;

import java.util.Arrays;
import java.util.Date;

public class CreateContributorDTO {
	
	private Long contributorsId;

	private Date dateCreated;

	private String contributorsGuid;

	private String contributorsName;

	private String contributorsBlogPage;
	
	private String contributorsYoutubePage;

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

	public String getContributorsYoutubePage() {
		return contributorsYoutubePage;
	}

	public void setContributorsYoutubePage(String contributorsYoutubePage) {
		this.contributorsYoutubePage = contributorsYoutubePage;
	}

	@Override
	public String toString() {
		return "CreateContributorDTO [contributorsId=" + contributorsId + ", dateCreated=" + dateCreated
				+ ", contributorsGuid=" + contributorsGuid + ", contributorsName=" + contributorsName
				+ ", contributorsBlogPage=" + contributorsBlogPage + ", contributorsYoutubePage="
				+ contributorsYoutubePage + "]";
	}




}
