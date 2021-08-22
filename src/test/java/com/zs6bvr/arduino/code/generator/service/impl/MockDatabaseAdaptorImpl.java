package com.zs6bvr.arduino.code.generator.service.impl;

import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.TestType;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToWriteToatabaseException;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;

public class MockDatabaseAdaptorImpl implements DatabaseAdaptor{
	
	private TestType testType;
	
	private MockDatabaseAdaptorImpl() {}	

	public MockDatabaseAdaptorImpl(TestType testType) {
		super();
		this.testType = testType;
	}



	@Override
	public UploadFeatureResponse persistFeatureRecord(UploadFeatureRequest request) throws FailedToWriteToatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectFeature findByProjectFeatureId(Long projectFeatureId) throws FailedToReadFromDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
