package com.zs6bvr.arduino.code.generator.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;



import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;

import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;


@Entity
@Table(name = "feature")
public class ProjectFeature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectFeatureId;
	
	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@Column(name="project_guid", nullable = false, updatable = true)
	private String projectGUID;	
	

	@Column(name="feature_name", nullable = false, updatable = true)
	private String featureName;
	
	@Column(name="feature_status", nullable = false, updatable = true)
	private String featureStatus;

	@Column(name="project_type", nullable = false, updatable = true)
	private String projectType;
	
	@Column(name="feature_decleration", nullable = false, updatable = true, length=2048)
	private String featureClassImports;
	
	@Column(name="feature_assignment", nullable = false, updatable = true, length=2048)
	private String featureAssignment;
	
	@Column(name="feature_code", nullable = false, updatable = true, length=4096)
	private String featurecode;

	
	@Column(name="description", nullable = false, updatable = true, length=2048)
	private String description;

	@Column(name="category", nullable = false, updatable = true)	
	private String category;
	
	@Column(name="prerequisites", nullable = false, updatable = true, length=2048)
	private String prerequisites;
	
	
	@Column(name="computer_language", nullable = false, updatable = true, length=128)// (should be mapped with insert="false" update="false")
	private String computerLanguage;

	@Column(name="micro_controller", nullable = false, updatable = true, length=128)// (should be mapped with insert="false" update="false")
	private String microController;
	
	@Column(name="mcu_pins", nullable = false, updatable = true, length=256)
	private String mcuPinsUsed;
	
	@Column(name="contributor", nullable = false, updatable = false, length=128)
	private String contributorsName;

	
	@Column(name="contributor_guid", nullable = false, updatable = false, length=128)
	private String contributorsGuid;
	
	@Column(name="contributor_blog", nullable = false, updatable = false, length=128)
	private String contributorsBlogPage;
	
	@Column(name="contributor_youtube", nullable = false, updatable = false, length=128)
	private String contributorsYoutubePage;
	

	
	public ProjectFeature() {
		dateCreated=new Date();
		projectGUID= UUID.randomUUID().toString(); 
	}


	public ProjectFeature(Date dateCreated, String projectGUID, String featureName, String featureStatus,
			String projectType, String featureClassImports, String featureAssignment, String featurecode,
			String description, String category, String prerequisites, String computerLanguage, String microController,
			String mcuPinsUsed, String contributorsName, String contributorsGuid, String contributorsBlogPage,
			String contributorsYoutubePage) {
		super();
		this.dateCreated = dateCreated;
		this.projectGUID = projectGUID;
		this.featureName = featureName;
		this.featureStatus = featureStatus;
		this.projectType = projectType;
		this.featureClassImports = featureClassImports;
		this.featureAssignment = featureAssignment;
		this.featurecode = featurecode;
		this.description = description;
		this.category = category;
		this.prerequisites = prerequisites;
		this.computerLanguage = computerLanguage;
		this.microController = microController;
		this.mcuPinsUsed = mcuPinsUsed;
		this.contributorsName = contributorsName;
		this.contributorsGuid = contributorsGuid;
		this.contributorsBlogPage = contributorsBlogPage;
		this.contributorsYoutubePage = contributorsYoutubePage;
	}





	public void setInitialValues() {
		dateCreated=new Date();
		projectGUID= UUID.randomUUID().toString(); 		
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



	public String getProjectType() {
		return projectType;
	}



	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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



	public String getFeatureStatus() {
		return featureStatus;
	}



	public void setFeatureStatus(String featureStatus) {
		this.featureStatus = featureStatus;
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



	public Long getProjectFeatureId() {
		return projectFeatureId;
	}



	public void setUploadFeatureRequest(UploadFeatureRequest request) {

		this.featureName = request.getFeatureName();
		this.featureStatus = request.getFeatureStatus();
		this.featureClassImports = request.getFeatureClassImports();
		this.featureAssignment = request.getFeatureAssignment();
		this.featurecode = request.getFeaturecode();
		this.description = request.getDescription();
		this.prerequisites = request.getPrerequisites();
		this.computerLanguage = request.getComputerLanguage();
		this.microController = request.getMicroController();
		this.mcuPinsUsed = request.getMcuPinsUsed();
		this.contributorsName = request.getContributorsName();
		this.contributorsBlogPage = request.getContributorsBlogPage();
		this.contributorsYoutubePage = request.getContributorsYoutubePage();
		
	}


	@Override
	public String toString() {
		return "ProjectFeature [projectFeatureId=" + projectFeatureId + ", dateCreated=" + dateCreated
				+ ", projectGUID=" + projectGUID + ", featureName=" + featureName + ", featureStatus=" + featureStatus
				+ ", projectType=" + projectType + ", featureClassImports=" + featureClassImports
				+ ", featureAssignment=" + featureAssignment + ", featurecode=" + featurecode + ", description="
				+ description + ", category=" + category + ", prerequisites=" + prerequisites + ", computerLanguage="
				+ computerLanguage + ", microController=" + microController + ", mcuPinsUsed=" + mcuPinsUsed
				+ ", contributorsName=" + contributorsName + ", contributorsGuid=" + contributorsGuid
				+ ", contributorsBlogPage=" + contributorsBlogPage + ", contributorsYoutubePage="
				+ contributorsYoutubePage + "]";
	}










	

}
