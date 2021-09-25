package com.zs6bvr.arduino.code.generator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.entities.ProjectFeature;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToReadFromDatabaseException;
import com.zs6bvr.arduino.code.generator.exceptions.FailedToWriteToatabaseException;
import com.zs6bvr.arduino.code.generator.repositories.FeatureRepository;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;
import com.zs6bvr.arduino.code.generator.utils.RequestResponseUtils;

@Service
public class DatabaseAdaptorImpl implements DatabaseAdaptor{
	private static final Logger log = LoggerFactory.getLogger(DatabaseAdaptorImpl.class);

	
	@Autowired
	FeatureRepository repository;


	@Override
	public ProjectFeature findByProjectFeatureId(Long projectFeatureId) throws FailedToReadFromDatabaseException {
		ProjectFeature projectFeature = null;

		try {
			projectFeature = repository.findByProjectFeatureId(projectFeatureId);
			log.info("DatabaseAdaptorImpl | findByProjectFeatureId | called the database");
			
		}catch(Exception e) {
			log.error("DatabaseAdaptorImpl | findByProjectFeatureId | failed to retrieve from database",e);
			throw new FailedToReadFromDatabaseException(e);
		}

		return projectFeature;
	}
	

	@Override
	public UploadFeatureResponse insertFeatureRecord(UploadFeatureRequest request) throws FailedToWriteToatabaseException {
		ProjectFeature projectFeature =null;
		ProjectFeature resultantFeature = null;
		UploadFeatureResponse response=null;

		log.info("DatabaseAdaptorImpl | insertFeatureRecord | request : "+request);
		
		try {
			projectFeature = RequestResponseUtils.makeProjectFeature(request);
			resultantFeature = repository.saveAndFlush(projectFeature);
			log.info("DatabaseAdaptorImpl | insertFeatureRecord | called the database");
			
			if(resultantFeature!=null) {
				response=RequestResponseUtils.makeSucceededToPersistResponse(resultantFeature);
			} else {
				response=RequestResponseUtils.makeSucceededToPersistResponse();
			}
		}catch(Exception e) {
			response=RequestResponseUtils.makeFailedToPersistResponse();
			log.error("DatabaseAdaptorImpl | insertFeatureRecord | failed to retrieve from database",e);
		}
		return response;
	}

	@Override
	public BuildProjectResponse getBuiltProject(BuildProjectRequest request) throws FailedToReadFromDatabaseException {
		log.info("DatabaseAdaptorImpl | getBuiltProject | request : "+request);
		
		return null;
	}

	@Override
	public UploadFeatureResponse getAllFeatures() {
		UploadFeatureResponse response=new UploadFeatureResponse();
		List<ProjectFeature> projectFeatures = null;
		
		try {
			projectFeatures = repository.findAll();

			String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
			String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
			response.setResponseStatusCode(expectedResponseStatusCode);
			response.setResponseStatusMessage(expectedResponseStatusMessage);
			
			if(projectFeatures!=null) {
				List<UploadFeatureDto> uploadFeatureDtos=RequestResponseUtils.makeUploadFeatureDtos(projectFeatures) ;
				if(uploadFeatureDtos!=null) {
					log.info("DatabaseAdaptorImpl | getAllFeatures | received "+uploadFeatureDtos.size()+"resords from database");
					response.setUploadFeatureDtos(uploadFeatureDtos);
				} else {
					log.info("DatabaseAdaptorImpl | getAllFeatures | uploadFeatureDtos is null");
				}
			}
		}catch(Exception e) {
			log.error("DatabaseAdaptorImpl | getAllFeatures | failed to retrieve from database",e);

			String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
			String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
			response.setResponseStatusCode(expectedResponseStatusCode);
			response.setResponseStatusMessage(expectedResponseStatusMessage);
		}	
		
		return response;
	}

	@Override
	public UploadFeatureResponse getFeature(Long id) {
		UploadFeatureResponse response=new UploadFeatureResponse();
		List<ProjectFeature> projectFeatures = new ArrayList<ProjectFeature>();
		
		try {
			ProjectFeature projectFeature=findByProjectFeatureId(id);
			projectFeatures.add(projectFeature);
			List<UploadFeatureDto> uploadFeatureDtos=RequestResponseUtils.makeUploadFeatureDtos(projectFeatures) ;
			response.setUploadFeatureDtos(uploadFeatureDtos);

			String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
			String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
			response.setResponseStatusCode(expectedResponseStatusCode);
			response.setResponseStatusMessage(expectedResponseStatusMessage);
			
		} catch (FailedToReadFromDatabaseException e) {
			log.error("UploadFeatureResponse | persistFeatureRecord | failed to retrieve from database",e);

			String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
			String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
			response.setResponseStatusCode(expectedResponseStatusCode);
			response.setResponseStatusMessage(expectedResponseStatusMessage);
		}
		return response;
	}

	@Override
	public UploadFeatureResponse updateFeature(Long id, UploadFeatureRequest request) {
		UploadFeatureResponse response=new UploadFeatureResponse();
		try {
			log.info("DatabaseAdaptorImpl | updateFeature | id : "+id +" request : "+request); 
			if(id==null || request==null ) {
				log.info("DatabaseAdaptorImpl | updateFeature | id or request is null"); 
				String expectedResponseStatusCode = ResponseStatusCodes.BAD_REQUEST.getResponseStatusCode();
				String expectedResponseStatusMessage = ResponseStatusMessages.BAD_REQUEST.getResponseStatusMessage();
				response.setResponseStatusCode(expectedResponseStatusCode);
				response.setResponseStatusMessage(expectedResponseStatusMessage);
				return response;
			}
			log.info("DatabaseAdaptorImpl | updateFeature | finding feature id : "+id);
			ProjectFeature projectFeature = repository.findByProjectFeatureId(id);
			if(projectFeature!=null) {
				log.info("DatabaseAdaptorImpl | updateFeature | found, updating, and saving feature : "+projectFeature);
				projectFeature.setUploadFeatureRequest(request);
				repository.save(projectFeature);				
				response=RequestResponseUtils.makeSucceededToPersistResponse(projectFeature);
			} else {

				String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
				String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
				response.setResponseStatusCode(expectedResponseStatusCode);
				response.setResponseStatusMessage(expectedResponseStatusMessage);
			}
			
		} catch (Exception e) {
			log.error("UploadFeatureResponse | persistFeatureRecord | failed to retrieve from database",e);

			String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
			String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
			response.setResponseStatusCode(expectedResponseStatusCode);
			response.setResponseStatusMessage(expectedResponseStatusMessage);
		}
		
		return response;
	}

}
