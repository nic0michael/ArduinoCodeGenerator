package com.zs6bvr.arduino.code.generator.service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToWriteToatabaseException;

public interface DatabaseAdaptor {

	UploadFeatureResponse persistFeatureRecord(UploadFeatureRequest request) throws FailedToWriteToatabaseException;
	ProjectFeature findByProjectFeatureId(Long projectFeatureId) throws FailedToReadFromDatabaseException;
	BuildProjectResponse getBuiltProject(BuildProjectRequest request) throws FailedToReadFromDatabaseException;
	UploadFeatureResponse getAllFeatures();
	UploadFeatureResponse getFeature(Long id);
	UploadFeatureResponse updateFeature(Long id, UploadFeatureRequest request);

}
