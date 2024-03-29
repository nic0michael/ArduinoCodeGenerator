package com.zs6bvr.arduino.code.generator.dtos;

import javax.persistence.Column;

import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;

public class UploadFeatureDto {

	private String projectGUID;	
	private String computerLanguage;	
	private String microController;	
	private String mcuPinsUsed;	
	private String contributorsName;
	private String contributorsGuid;	
	private String contributorsBlogPage;	
	private String contributorsYoutubePage;
	private String featureName;	
	private String description;		
	private String category;
	private String otherCategory;
	private String prerequisites;	
	private String featureClassImports;
	private String featureAssignment;
	private String featurecode;
	private String featureStatus;	
	private String projectType;

	public UploadFeatureDto() {}

	public UploadFeatureDto(String projectGUID, String computerLanguage, String microController, String mcuPinsUsed,
			String contributorsName, String contributorsGuid, String contributorsBlogPage,
			String contributorsYoutubePage, String featureName, String description, String category,
			String otherCategory, String prerequisites, String featureClassImports, String featureAssignment,
			String featurecode, String featureStatus, String projectType) {
		super();
		this.projectGUID = projectGUID;
		this.computerLanguage = computerLanguage;
		this.microController = microController;
		this.mcuPinsUsed = mcuPinsUsed;
		this.contributorsName = contributorsName;
		this.contributorsGuid = contributorsGuid;
		this.contributorsBlogPage = contributorsBlogPage;
		this.contributorsYoutubePage = contributorsYoutubePage;
		this.featureName = featureName;
		this.description = description;
		this.category = category;
		this.otherCategory = otherCategory;
		this.prerequisites = prerequisites;
		this.featureClassImports = featureClassImports;
		this.featureAssignment = featureAssignment;
		this.featurecode = featurecode;
		this.featureStatus = featureStatus;
		this.projectType = projectType;
	}


public void makeNewData() {	
	if(projectGUID             == null){                   projectGUID = "dummy_projectGUID";               }         
	if(computerLanguage        == null){              computerLanguage = "dummy_computerLanguage";          }    
	if(microController         == null){               microController = "dummy_microController";           }     
	if(mcuPinsUsed             == null){                   mcuPinsUsed = "dummy_mcuPinsUsed";               }         
	if(contributorsName        == null){              contributorsName = "dummy_contributorsName";          }    
	if(contributorsGuid        == null){              contributorsGuid = "dummy_contributorsGuid";          }    
	if(contributorsBlogPage    == null){          contributorsBlogPage = "dummy_contributorsBlogPage";      }
	if(contributorsYoutubePage == null){       contributorsYoutubePage = "dummy_contributorsYoutubePage";   }
	if(featureName             == null){                   featureName = "dummy_featureName";               }         
	if(description             == null){                   description = "dummy_description";               }         
	if(category                == null){                      category = "dummy_category";                  }            
	if(otherCategory           == null){                 otherCategory = "dummy_otherCategory";             }       
	if(prerequisites           == null){                 prerequisites = "dummy_prerequisites";             }       
	if(featureClassImports     == null){           featureClassImports = "dummy_featureClassImports";       } 
	if(featureAssignment       == null){             featureAssignment = "dummy_featureAssignment";         }   
	if(featurecode             == null){                   featurecode = "dummy_featurecode";               }         
	if(featureStatus           == null){                 featureStatus = "in_progress";             }       
	if(projectType             == null){                 projectType   = "dummy_projectType";               }
}






	public UploadFeatureDto(ProjectFeature projectFeature) {
		if(projectFeature!=null) {
			category=projectFeature.getCategory(); 
			projectGUID = projectFeature.getProjectGUID();
			computerLanguage = projectFeature.getComputerLanguage();
			microController = projectFeature.getMicroController();
			mcuPinsUsed = projectFeature.getMcuPinsUsed();
			contributorsName = projectFeature.getContributorsName();
			contributorsGuid =projectFeature.getContributorsGuid();
			contributorsBlogPage = projectFeature.getContributorsBlogPage();
			contributorsYoutubePage = projectFeature.getContributorsYoutubePage();
			featureName = projectFeature.getFeatureName();
			description = projectFeature.getDescription();
			prerequisites = projectFeature.getPrerequisites();
			featureClassImports = projectFeature.getFeatureClassImports();
			featureAssignment = projectFeature.getFeatureAssignment();
			featurecode = projectFeature.getFeaturecode();
			featureStatus = projectFeature.getFeatureStatus();
			projectType=projectFeature.getProjectType();
		}
	}





	public String getOtherCategory() {
		return otherCategory;
	}

	public void setOtherCategory(String otherCategory) {
		this.otherCategory = otherCategory;
	}

	public String getContributorsGuid() {
		return contributorsGuid;
	}


	public void setContributorsGuid(String contributorsGuid) {
		this.contributorsGuid = contributorsGuid;
	}


	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
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





	public String getFeatureClassImports() {
		return featureClassImports;
	}





	public void setFeatureClassImports(String featureClassImports) {
		this.featureClassImports = featureClassImports;
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





	public String getFeatureStatus() {
		return featureStatus;
	}





	public void setFeatureStatus(String featureStatus) {
		this.featureStatus = featureStatus;
	}





	public String getProjectType() {
		return projectType;
	}





	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}


	@Override
	public String toString() {
		return "UploadFeatureDto [projectGUID=" + projectGUID + ", computerLanguage=" + computerLanguage
				+ ", microController=" + microController + ", mcuPinsUsed=" + mcuPinsUsed + ", contributorsName="
				+ contributorsName + ", contributorsGuid=" + contributorsGuid + ", contributorsBlogPage="
				+ contributorsBlogPage + ", contributorsYoutubePage=" + contributorsYoutubePage + ", featureName="
				+ featureName + ", description=" + description + ", category=" + category + ", prerequisites="
				+ prerequisites + ", featureClassImports=" + featureClassImports + ", featureAssignment="
				+ featureAssignment + ", featurecode=" + featurecode + ", featureStatus=" + featureStatus
				+ ", projectType=" + projectType + "]";
	}











	
}
