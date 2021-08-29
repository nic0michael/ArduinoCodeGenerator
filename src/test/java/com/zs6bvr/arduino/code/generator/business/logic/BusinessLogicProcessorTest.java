package com.zs6bvr.arduino.code.generator.business.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.enums.TestType;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;
import com.zs6bvr.arduino.code.generator.service.impl.CodeMakerServiceImpl;
import com.zs6bvr.arduino.code.generator.service.impl.MockDatabaseAdaptorImpl;
import com.zs6bvr.arduino.code.generator.validators.RequestValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		
		BuildProjectRequest request = makeBuildProjectRequest();
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
		
		BuildProjectRequest request = makeBadBuildProjectRequest();
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
		
		BuildProjectRequest request = makeBadBuildProjectRequest();
		String result = processor.getBuiltProject(request);
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
		
		BuildProjectRequest request = makeBuildProjectRequest();
		String result = processor.getBuiltProject(request);
		assertNotNull(result);
		int resultLength=result.length();
		System.out.println("resultLength : "+resultLength);
		assertEquals(resultLength, expectedResultLength);
	}


	private BuildProjectRequest makeBadBuildProjectRequest() {
		BuildProjectRequest request = makeBuildProjectRequest();
		request.setProjectName(null);
		return request;
	}

	private BuildProjectRequest makeBuildProjectRequest() {
		BuildProjectRequest request = new BuildProjectRequest();
		request.setProjectName("ProjectName");
		request.setFirstModule("FirstModule");
		return request;
	}
}
