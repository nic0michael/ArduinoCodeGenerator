package com.zs6bvr.arduino.code.generator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;

@Service
public class CodeMakerServiceImpl implements CodeMakerService{
	
	@Autowired
	private DatabaseAdaptor database;
	
	private List<ProjectFeature> features;
	
	public CodeMakerServiceImpl() {}	

	public CodeMakerServiceImpl(DatabaseAdaptor database) {
		super();
		this.database = database;
	}

	@Override
	public String doBuildProject(BuildProjectRequest request) {
		populateProjectFeatureList(request);
		return "";
	}

	private void populateProjectFeatureList(BuildProjectRequest request) {
		features=new ArrayList<>();
		String id=request.getFirstModule();
		populateProjectFeatureList(id);
		
		id=request.getSecondModule();
		populateProjectFeatureList(id);
		
		id=request.getThirdModule();
		populateProjectFeatureList(id);
		
		id=request.getForthModule();
		populateProjectFeatureList(id);
		
		id=request.getFifthModule();
		populateProjectFeatureList(id);
		
	}
	
	private void populateProjectFeatureList(String featureId) {
		ProjectFeature feature=null;
		if(StringUtils.isNotEmpty(featureId) && StringUtils.isNumeric(featureId)) { 
			Long projectFeatureId=Long.parseLong(featureId);
			try {
				feature=database.findByProjectFeatureId(projectFeatureId);
				features.add(feature);
			} catch (FailedToReadFromDatabaseException e) {
				e.printStackTrace();
			}
		}
	}
}
