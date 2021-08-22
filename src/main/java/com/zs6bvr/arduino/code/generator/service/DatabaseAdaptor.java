package com.zs6bvr.arduino.code.generator.service;

import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToWriteToatabaseException;

public interface DatabaseAdaptor {

	UploadFeatureResponse persistFeatureRecord(UploadFeatureRequest request) throws FailedToWriteToatabaseException;
	ProjectFeature findByProjectFeatureId(Long projectFeatureId) throws FailedToReadFromDatabaseException;

}
