package com.zs6bvr.arduino.code.generator.entities;

import java.sql.Timestamp;
import java.util.Date;

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
	
	@Column(name="project_guid")
	private String projectGUID;	
	
	@Column(name="feature_name", unique = true, nullable = false, updatable = false, insertable = false, length=128)
	private String featureName;
	
	@Column(name="feature_status")
	private String featureStatus;
	
	@Column(name="feature_decleration", nullable = false, updatable = true, length=2048)
	private String featureDecleration;
	
	@Column(name="feature_assignment", nullable = false, updatable = true, length=2048)
	private String featureAssignment;
	
	@Column(name="feature_code", nullable = false, updatable = true, length=4096)
	private String featurecode;

	
	@Column(name="description", nullable = false, updatable = true, length=2048)
	private String description;

	
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
	
	@Column(name="contributor_blog", nullable = false, updatable = false, length=128)
	private String contributorsBlogPage;
	
	@Column(name="contributor_youtube", nullable = false, updatable = false, length=128)
	private String contributorsYoutubePage;
	

	
	public ProjectFeature() {
		dateCreated=new Date();
	}



	public ProjectFeature(String projectGUID, String featureName, String featureStatus, String featureDecleration,
			String featureAssignment, String featurecode, String description, String prerequisites,
			String computerLanguage, String microController, String mcuPinsUsed, String contributorsName,
			String contributorsBlogPage, String contributorsYoutubePage) {
		super();
		this.projectGUID = projectGUID;
		this.featureName = featureName;
		this.featureStatus = featureStatus;
		this.featureDecleration = featureDecleration;
		this.featureAssignment = featureAssignment;
		this.featurecode = featurecode;
		this.description = description;
		this.prerequisites = prerequisites;
		this.computerLanguage = computerLanguage;
		this.microController = microController;
		this.mcuPinsUsed = mcuPinsUsed;
		this.contributorsName = contributorsName;
		this.contributorsBlogPage = contributorsBlogPage;
		this.contributorsYoutubePage = contributorsYoutubePage;

		dateCreated=new Date();
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



	public Date getDateCreated() {
		return dateCreated;
	}



	@Override
	public String toString() {
		return "ProjectFeature [projectFeatureId=" + projectFeatureId + ", dateCreated=" + dateCreated
				+ ", projectGUID=" + projectGUID + ", featureName=" + featureName + ", featureStatus=" + featureStatus
				+ ", featureDecleration=" + featureDecleration + ", featureAssignment=" + featureAssignment
				+ ", featurecode=" + featurecode + ", description=" + description + ", prerequisites=" + prerequisites
				+ ", computerLanguage=" + computerLanguage + ", microController=" + microController + ", mcuPinsUsed="
				+ mcuPinsUsed + ", contributorsName=" + contributorsName + ", contributorsBlogPage="
				+ contributorsBlogPage + ", contributorsYoutubePage=" + contributorsYoutubePage + "]";
	}



	public void setUploadFeatureRequest(UploadFeatureRequest request) {

		this.projectGUID = request.getProjectGUID();
		this.featureName = request.getFeatureName();
		this.featureStatus = request.getFeatureStatus();
		this.featureDecleration = request.getFeatureDecleration();
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


	

}
