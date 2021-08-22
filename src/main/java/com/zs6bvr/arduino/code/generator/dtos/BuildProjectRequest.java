package com.zs6bvr.arduino.code.generator.dtos;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BuildProjectRequest")
public class BuildProjectRequest {


	String projectName;
	String description="This project was not given a decscription";
	String firstModule;
	String secondModule;
	String ThirdModule;
	String forthModule;
	String fifthModule;
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
	@Override
	public String toString() {
		return "BuildProjectRequest [projectName=" + projectName + ", description=" + description + ", firstModule="
				+ firstModule + ", secondModule=" + secondModule + ", ThirdModule=" + ThirdModule + ", forthModule="
				+ forthModule + ", fifthModule=" + fifthModule + "]";
	}

	

	
	

}
