package com.zs6bvr.arduino.code.generator.business.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureDto;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;
import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureResponse;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.enums.TestType;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;
import com.zs6bvr.arduino.code.generator.service.impl.CodeMakerServiceImpl;
import com.zs6bvr.arduino.code.generator.service.impl.MockDatabaseAdaptorImpl;
import com.zs6bvr.arduino.code.generator.utils.RequestResponseUtils;
import com.zs6bvr.arduino.code.generator.validators.RequestValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

@SpringBootTest
public class BusinessLogicProcessorTest { 


	@DisplayName("Positive Test BusinessLogicProcessorTest1")
	@Test
	void positiveTestValidateBuildProjectRequest() {
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		BuildProjectRequest request = RequestResponseUtils.makeBuildProjectRequest();
		BuildProjectResponse response = processor.validateRequest(request);
		assertNotNull(response);
		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
	}
	
	@DisplayName("Negative Test BusinessLogicProcessorTest2")
	@Test
	void negativeTestValidateBuildProjectRequest() {
		String expectedResponseStatusCode = ResponseStatusCodes.MISSING_PROJECT_NAME.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.MISSING_PROJECT_NAME.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		BuildProjectRequest request = RequestResponseUtils.makeBadBuildProjectRequest();
		BuildProjectResponse response = processor.validateRequest(request);
		assertNotNull(response);
		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
	}

	@DisplayName("Negative Test BusinessLogicProcessorTest3")
	@Test
	void negativeTestDoBuildProject() {
		String expectedResponseStatusMessage = ResponseStatusMessages.MISSING_PROJECT_NAME.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		BuildProjectRequest request = RequestResponseUtils.makeBadBuildProjectRequest();
		String result = processor.generateProject(request);
		assertNotNull(result);
		assertEquals(result, expectedResponseStatusMessage);
	}
	

	@DisplayName("Positive Test BusinessLogicProcessorTest4")
	@Test
	void positiveTestDoBuildProject() {
		int expectedResultLength=527;
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		BuildProjectRequest request = RequestResponseUtils.makeBuildProjectRequest();
		String result = processor.generateProject(request);
		assertNotNull(result);
		int resultLength=result.length();
		System.out.println("resultLength : "+resultLength);
		assertEquals(resultLength, expectedResultLength);
	}

	

	@DisplayName("Positive Test BusinessLogicProcessorTest5")
	@Test
	void positiveTestGetAllFeatures() {
		String expectedFeatureName="DummyfeatureName";
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);

		UploadFeatureResponse response = processor.getAllFeatures();
		assertNotNull(response);
		List<UploadFeatureDto> featureDtos=response.getUploadFeatureDtos();
		assertNotNull(featureDtos);
		UploadFeatureDto featureDto = featureDtos.get(0);
		assertNotNull(featureDto);
		String featureName = featureDto.getFeatureName();
		System.out.println("featureName : "+featureName);
		assertEquals(featureName, expectedFeatureName);
	}
	

	@DisplayName("Negative Test BusinessLogicProcessorTest6")
	@Test
	void negativeTestGetAllFeatures() {

		String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.FAILING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);

		UploadFeatureResponse response = processor.getAllFeatures();
		assertNotNull(response);
		List<UploadFeatureDto> featureDtos=response.getUploadFeatureDtos();
		assertNull(featureDtos);
		

		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		System.out.println("responseStatusMessage : "+responseStatusMessage);
		System.out.println("responseStatusCode : "+responseStatusCode);
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
		
		
	}
		

	@DisplayName("Positive Test BusinessLogicProcessorTest7")
	@Test
	void positiveTestGetFeature() {
		String expectedFeatureName="DummyfeatureName";
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		Long id=1L;
		UploadFeatureResponse response = processor.getFeature(id);
		assertNotNull(response);
		List<UploadFeatureDto> featureDtos=response.getUploadFeatureDtos();
		assertNotNull(featureDtos);
		UploadFeatureDto featureDto = featureDtos.get(0);
		assertNotNull(featureDto);
		String featureName = featureDto.getFeatureName();
		System.out.println("featureName : "+featureName);
		assertEquals(featureName, expectedFeatureName);
	}

	@DisplayName("Negative Test BusinessLogicProcessorTest8")
	@Test
	void negativeTestGetFeature() {

		String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.FAILING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);


		Long id=1L;
		UploadFeatureResponse response = processor.getFeature(id);
		assertNotNull(response);
		List<UploadFeatureDto> featureDtos=response.getUploadFeatureDtos();
		assertNull(featureDtos);
		

		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		System.out.println("responseStatusMessage : "+responseStatusMessage);
		System.out.println("responseStatusCode : "+responseStatusCode);
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
		
		
	}

	@DisplayName("Positive Test BusinessLogicProcessorTest9")
	@Test
	void positiveTestUpdateFeature() {
		String expectedFeatureName="DummyfeatureName";
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		Long id=1L;
		 UploadFeatureRequest request=RequestResponseUtils.makeUploadFeatureRequest();
		UploadFeatureResponse response = processor.updateFeature(id,request);
		assertNotNull(response);
		List<UploadFeatureDto> featureDtos=response.getUploadFeatureDtos();
		assertNotNull(featureDtos);
		UploadFeatureDto featureDto = featureDtos.get(0);
		assertNotNull(featureDto);
		String featureName = featureDto.getFeatureName();
		System.out.println("featureName : "+featureName);
		assertEquals(featureName, expectedFeatureName);
	}

	@DisplayName("Negative Test BusinessLogicProcessorTest10")
	@Test
	void negativeTestUpdateFeature() {

		String expectedResponseStatusCode = ResponseStatusCodes.DATABASE_FAILURE.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.DATABASE_FAILURE.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.FAILING_TEST);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);

		Long id=1L;
		UploadFeatureRequest request=RequestResponseUtils.makeUploadFeatureRequest();
		UploadFeatureResponse response = processor.updateFeature(id,request);
		assertNotNull(response);
		List<UploadFeatureDto> featureDtos=response.getUploadFeatureDtos();
		assertNull(featureDtos);
		

		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		System.out.println("responseStatusMessage : "+responseStatusMessage);
		System.out.println("responseStatusCode : "+responseStatusCode);
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);		
		
	}
}
