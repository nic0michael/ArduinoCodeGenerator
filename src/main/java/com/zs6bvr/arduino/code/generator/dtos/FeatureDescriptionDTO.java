package com.zs6bvr.arduino.code.generator.dtos;

public class FeatureDescriptionDTO {

	private String projectGUID;	
	private String featureName;	
	private String description;	
	private String featureStatus;
	private String computerLanguage;	
	private String microController;	
	private String projectType;

	public FeatureDescriptionDTO() {}

	public FeatureDescriptionDTO(String projectGUID, String featureName, String description, String featureStatus,
			String computerLanguage, String microController, String projectType) {
		super();
		this.projectGUID = projectGUID;
		this.featureName = featureName;
		this.description = description;
		this.featureStatus = featureStatus;
		this.computerLanguage = computerLanguage;
		this.microController = microController;
		this.projectType=projectType;
	}

	
	
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectGUID() {
		return projectGUID;
	}

	public void setProjectGUID(String projectGUID) {
		this.projectGUID = projectGUID;
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

	public String getFeatureStatus() {
		return featureStatus;
	}

	public void setFeatureStatus(String featureStatus) {
		this.featureStatus = featureStatus;
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
	
	public void setFeatureDescriptionDTO(UploadFeatureDto dto) {
		
		this.projectGUID = dto.getProjectGUID();
		this.featureName = dto.getFeatureName();
		this.description = dto.getDescription();
		this.featureStatus = dto.getFeatureStatus();
		this.computerLanguage = dto.getComputerLanguage();
		this.microController = dto.getMicroController();
		this.projectType=dto.getProjectType();
	}

	@Override
	public String toString() {
		return "FeatureDescriptionDTO [projectGUID=" + projectGUID + ", featureName=" + featureName + ", description="
				+ description + ", featureStatus=" + featureStatus + ", computerLanguage=" + computerLanguage
				+ ", microController=" + microController + ", projectType=" + projectType + "]";
	}


	


}
