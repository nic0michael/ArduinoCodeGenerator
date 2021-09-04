package com.zs6bvr.arduino.code.generator.service.impl;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.TestType;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToWriteToatabaseException;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;
import com.zs6bvr.arduino.code.generator.utils.RequestResponseUtils;


public class MockDatabaseAdaptorImpl implements DatabaseAdaptor{
	
	private TestType testType;
	
	private MockDatabaseAdaptorImpl() {}	

	public MockDatabaseAdaptorImpl(TestType testType) {
		super();
		this.testType = testType;
	}



	@Override
	public UploadFeatureResponse persistFeatureRecord(UploadFeatureRequest request) throws FailedToWriteToatabaseException {

		UploadFeatureResponse response=null;
		String operationType = testType.name();

		switch (operationType) {
		case "PASSING_TEST":
			response=RequestResponseUtils.makeSuccessUploadFeatureResponse(); 
			break;
			
		case "FAILING_TEST":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
			break;

		case "THROWS_EXCEPTION":
			throw new FailedToWriteToatabaseException();

		default:
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
		}

		return response;
	}

	@Override
	public ProjectFeature findByProjectFeatureId(Long projectFeatureId) throws FailedToReadFromDatabaseException {

		ProjectFeature projectFeature=null;
		String operationType = testType.name();

		switch (operationType) {
		case "PASSING_TEST":
			projectFeature=RequestResponseUtils.makeSuccessProjectFeature(); 
			break;
			
		case "FAILING_TEST":
			projectFeature=null; 
			break;

		case "THROWS_EXCEPTION":
			throw new FailedToReadFromDatabaseException();

		default:
			projectFeature=null; 
		}

		return projectFeature;
	}

	@Override
	public BuildProjectResponse getBuiltProject(BuildProjectRequest request) throws FailedToReadFromDatabaseException {
		BuildProjectResponse response=null;
		
		String operationType = testType.name();

		switch (operationType) {
		case "PASSING_TEST":
			response=RequestResponseUtils.makeSuccessBuildProjectResponse(); 
			break;
			
		case "FAILING_TEST":
			response=RequestResponseUtils.makeDatabaseFailedBuildProjectResponse(); 
			break;

		case "THROWS_EXCEPTION":
			throw new FailedToReadFromDatabaseException();

		default:
			response=RequestResponseUtils.makeDatabaseFailedBuildProjectResponse(); 
		}

		return response;
	}

	@Override
	public UploadFeatureResponse getAllFeatures() {

		UploadFeatureResponse response=null;
		String operationType = testType.name();

		switch (operationType) {
		case "PASSING_TEST":
			response=RequestResponseUtils.makeSuccessUploadFeatureResponse(); 
			break;
			
		case "FAILING_TEST":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
			break;

		case "THROWS_EXCEPTION":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 

		default:
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
		}

		return response;
	}

	@Override
	public UploadFeatureResponse getFeature(Long id) {

		UploadFeatureResponse response=null;
		String operationType = testType.name();

		switch (operationType) {
		case "PASSING_TEST":
			response=RequestResponseUtils.makeSuccessUploadFeatureResponse(); 
			break;
			
		case "FAILING_TEST":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
			break;

		case "THROWS_EXCEPTION":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 

		default:
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
		}

		return response;
	}

	@Override
	public UploadFeatureResponse updateFeature(Long id, UploadFeatureRequest request) {

		UploadFeatureResponse response=null;
		String operationType = testType.name();

		switch (operationType) {
		case "PASSING_TEST":
			response=RequestResponseUtils.makeSuccessUploadFeatureResponse(); 
			break;
			
		case "FAILING_TEST":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
			break;

		case "THROWS_EXCEPTION":
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 

		default:
			response=RequestResponseUtils.makeDatabaseFailedUploadFeatureResponse(); 
		}

		return response;
	}

}
