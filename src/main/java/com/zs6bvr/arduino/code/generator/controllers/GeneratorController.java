package com.zs6bvr.arduino.code.generator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs6bvr.arduino.code.generator.business.logic.BusinessLogicProcessor;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;



@RestController
@RequestMapping("generate")
public class GeneratorController {
	private static final Logger log = LoggerFactory.getLogger(GeneratorController.class);
	
	@Autowired
	BusinessLogicProcessor processor;
	

	@PostMapping(value = "/project", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String getProjectIssuesList(@RequestBody BuildProjectRequest request) {
		return processor.doBuildProject(request);
	}
	

	@PostMapping(value = "/featurerecord", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse persistFeatureRecord(@RequestBody UploadFeatureRequest request) {
		return processor.persistFeatureRecord(request);
	}
	

}
