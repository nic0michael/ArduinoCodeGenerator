package com.zs6bvr.arduino.code.generator.controllers;

import java.util.List;
import java.util.UUID;

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
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDescritionsResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;



@RestController
@RequestMapping("/arduino/v1")
public class GeneratorController {
	private static final Logger log = LoggerFactory.getLogger(GeneratorController.class);
	
	@Autowired
	BusinessLogicProcessor processor;
	String GUID= UUID.randomUUID().toString(); 

	@PostMapping(value = "/generateuserguid")
	public String generateUserGuid() {
		String userGuid= UUID.randomUUID().toString(); 
		log.info("GeneratorController | generateUserGuid | userGuid : "+userGuid);
		return userGuid;
	}

	@PostMapping(value = "/generatecode", 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String generateProjectCode(@RequestBody BuildProjectRequest request) {
		log.info("GeneratorController | generateProjectCode | called");
		return processor.generateProjectCode(request);
	}
	


	@PostMapping(value = "/generatenewcode", 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String generateNewProjectCode(@RequestBody BuildProjectRequest request) {
		log.info("GeneratorController | generateProjectCode | called");
		return processor.generateNewProjectCode(request);
	}
	

	@PostMapping(value = "/export", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureDto getExportedProject(@RequestBody BuildProjectRequest request) {
		log.info("GeneratorController | getExportedProject | called");
		BuildProjectResponse response = processor.getExportedProject(request);
		log.info("GeneratorController | getExportedProject | response : "+response);
		UploadFeatureDto json = response.getJsonProjectExport();
		return json;
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse persistFeature(@RequestBody UploadFeatureRequest request) {
		log.info("GeneratorController | persistFeature | called");
		return processor.saveFeature(request);
	}

	@PutMapping(value = "/update/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse updateFeature(@PathVariable( "id" ) Long id, @RequestBody UploadFeatureRequest request) {
		log.info("GeneratorController | updateFeature | called");
		return processor.updateFeature(id,request);
	}
	
	@GetMapping(value = "/descriptions", 
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureDescritionsResponse getDescriptionsOfAllFeatures() {
		log.info("GeneratorController | getDescriptionsOfAllFeatures | called");
		return processor.getDescriptionsOfAllFeatures();
	}

	
	@GetMapping(value = "/categories", 
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public List<String> getCategories() {
		log.info("GeneratorController | getDescriptionsOfAllFeatures | called");
		return processor.getCategories();
	}

	@GetMapping(value = "/features", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse getAllFeatures() {
		log.info("GeneratorController | getAllFeatures | called");
		return processor.getAllFeatures();

	}

	@GetMapping(value = "/allfeatures/{category}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse getFeature(@PathVariable( "category" ) String category) {
		log.info("GeneratorController | getFeature | called");
		return processor.getFeatures(category);
	}

	@GetMapping(value = "/features/{id}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse getFeature(@PathVariable( "id" ) Long id) {
		log.info("GeneratorController | getFeature | called");
		return processor.getFeature(id);
	}

	@GetMapping(value = "/feature/{projectGUID}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public UploadFeatureResponse getFeatureForProjectGuid(@PathVariable( "projectGUID" ) String projectGUID) {
		log.info("GeneratorController | getFeature | called");
		return processor.getFeature(projectGUID);
	}
	

}
