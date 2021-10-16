package com.zs6bvr.arduino.code.generator.dtos;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BuildProjectRequest")
public class BuildProjectRequest {


	private String projectName;
	private String description="This project was not given a decscription";
	
	private String featureName;	
	private String category;
	private String prerequisites;
	private String featureDecleration;
	private String computerLanguage;	
	private String microController;	
	private String contributorsName;
	private String contributorsBlogPage;
	private String contributorsYoutubePage;
	
	private String firstModule;
	private String secondModule;
	private String ThirdModule;
	private String forthModule;
	private String fifthModule;
	private String guid;
	private String projectType;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
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
	public String getFirstModule() {
		return firstModule;
	}
	public void setFirstModule(String firstModule) {
		this.firstModule = firstModule;
	}
	public String getSecondModule() {
		return secondModule;
	}
	public void setSecondModule(String secondModule) {
		this.secondModule = secondModule;
	}
	public String getThirdModule() {
		return ThirdModule;
	}
	public void setThirdModule(String thirdModule) {
		ThirdModule = thirdModule;
	}
	public String getForthModule() {
		return forthModule;
	}
	public void setForthModule(String forthModule) {
		this.forthModule = forthModule;
	}
	public String getFifthModule() {
		return fifthModule;
	}
	public void setFifthModule(String fifthModule) {
		this.fifthModule = fifthModule;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	@Override
	public String toString() {
		return "BuildProjectRequest [projectName=" + projectName + ", description=" + description + ", featureName="
				+ featureName + ", category=" + category + ", prerequisites=" + prerequisites + ", featureDecleration="
				+ featureDecleration + ", computerLanguage=" + computerLanguage + ", microController=" + microController
				+ ", contributorsName=" + contributorsName + ", contributorsBlogPage=" + contributorsBlogPage
				+ ", contributorsYoutubePage=" + contributorsYoutubePage + ", firstModule=" + firstModule
				+ ", secondModule=" + secondModule + ", ThirdModule=" + ThirdModule + ", forthModule=" + forthModule
				+ ", fifthModule=" + fifthModule + ", guid=" + guid + ", projectType=" + projectType + "]";
	}


	
	
	

	
	

}
