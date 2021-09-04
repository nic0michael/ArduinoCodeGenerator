package com.zs6bvr.arduino.code.generator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs6bvr.arduino.code.generator.business.logic.BusinessLogicProcessor;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDescritionsResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;



@RestController
@RequestMapping("arduino")
public class GeneratorController {
	private static final Logger log = LoggerFactory.getLogger(GeneratorController.class);
	
	@Autowired
	BusinessLogicProcessor processor;
	

	@PostMapping(value = "/generate", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String getBuiltProject(@RequestBody BuildProjectRequest request) {
		return processor.generateProject(request);
	}
	
	@GetMapping(value = "/descriptions}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureDescritionsResponse getDescriptionsOfAllFeatures() {
		return processor.getDescriptionsOfAllFeatures();
	}
	
	@PostMapping(value = "/feature", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse persistFeature(@RequestBody UploadFeatureRequest request) {
		return processor.saveFeature(request);
	}
	

	@GetMapping(value = "/feature}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse getAllFeatures() {
		return processor.getAllFeatures();
	}

	@GetMapping(value = "/feature/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse getFeature(@PathVariable( "id" ) Long id) {
		return processor.getFeature(id);
	}
	

	@PutMapping(value = "/feature/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse updateFeature(@PathVariable( "id" ) Long id, @RequestBody UploadFeatureRequest request) {
		return processor.updateFeature(id,request);
	}
}
