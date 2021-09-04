package com.zs6bvr.arduino.code.generator.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UploadFeatureRequest")
public class UploadFeatureRequest {
	

	private String projectGUID;
	
	private String computerLanguage;
	
	private String microController;
	
	private String mcuPinsUsed;
	
	private String contributorsName;
	
	private String contributorsBlogPage;
	
	private String contributorsYoutubePage;	
	
	private String featureStatus;

	private String featureName;
	
	private String description;
	
	private String prerequisites;
	
	private String featureDecleration;

	private String featureAssignment;

	private String featurecode;

	public UploadFeatureRequest() {}

	public UploadFeatureRequest(String projectGUID, String computerLanguage, String microController, String mcuPinsUsed,
			String contributorsName, String contributorsBlogPage, String contributorsYoutubePage, String featureStatus,
			String featureName, String description, String prerequisites, String featureDecleration,
			String featureAssignment, String featurecode) {
		super();
		this.projectGUID = projectGUID;
		this.computerLanguage = computerLanguage;
		this.microController = microController;
		this.mcuPinsUsed = mcuPinsUsed;
		this.contributorsName = contributorsName;
		this.contributorsBlogPage = contributorsBlogPage;
		this.contributorsYoutubePage = contributorsYoutubePage;
		this.featureStatus = featureStatus;
		this.featureName = featureName;
		this.description = description;
		this.prerequisites = prerequisites;
		this.featureDecleration = featureDecleration;
		this.featureAssignment = featureAssignment;
		this.featurecode = featurecode;
	}

	public String getProjectGUID() {
		return projectGUID;
	}

	public void setProjectGUID(String projectGUID) {
		this.projectGUID = projectGUID;
	}

	public String getComputerLanguage() {
		return computerLanguage;
	}

	public void setComputerLanguage(String computerLanguage) {
		this.computerLanguage = computerLanguage;
	}

	public String getMicroController() {
		return microController;
	}

	public void setMicroController(String microController) {
		this.microController = microController;
	}

	public String getMcuPinsUsed() {
		return mcuPinsUsed;
	}

	public void setMcuPinsUsed(String mcuPinsUsed) {
		this.mcuPinsUsed = mcuPinsUsed;
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

	public String getFeatureStatus() {
		return featureStatus;
	}

	public void setFeatureStatus(String featureStatus) {
		this.featureStatus = featureStatus;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getFeatureDecleration() {
		return featureDecleration;
	}

	public void setFeatureDecleration(String featureDecleration) {
		this.featureDecleration = featureDecleration;
	}

	public String getFeatureAssignment() {
		return featureAssignment;
	}

	public void setFeatureAssignment(String featureAssignment) {
		this.featureAssignment = featureAssignment;
	}

	public String getFeaturecode() {
		return featurecode;
	}

	public void setFeaturecode(String featurecode) {
		this.featurecode = featurecode;
	}

	@Override
	public String toString() {
		return "UploadFeatureRequest [projectGUID=" + projectGUID + ", computerLanguage=" + computerLanguage
				+ ", microController=" + microController + ", mcuPinsUsed=" + mcuPinsUsed + ", contributorsName="
				+ contributorsName + ", contributorsBlogPage=" + contributorsBlogPage + ", contributorsYoutubePage="
				+ contributorsYoutubePage + ", featureStatus=" + featureStatus + ", featureName=" + featureName
				+ ", description=" + description + ", prerequisites=" + prerequisites + ", featureDecleration="
				+ featureDecleration + ", featureAssignment=" + featureAssignment + ", featurecode=" + featurecode
				+ "]";
	}

	

	
}
