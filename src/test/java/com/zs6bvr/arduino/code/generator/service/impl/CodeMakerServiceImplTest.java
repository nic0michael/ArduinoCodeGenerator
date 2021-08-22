package com.zs6bvr.arduino.code.generator.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.zs6bvr.arduino.code.generator.business.logic.BusinessLogicProcessor;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectRequest;
import com.zs6bvr.arduino.code.generator.dtos.BuildProjectResponse;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusCodes;
import com.zs6bvr.arduino.code.generator.enums.ResponseStatusMessages;
import com.zs6bvr.arduino.code.generator.enums.TestType;
import com.zs6bvr.arduino.code.generator.service.CodeMakerService;
import com.zs6bvr.arduino.code.generator.service.DatabaseAdaptor;
import com.zs6bvr.arduino.code.generator.service.impl.CodeMakerServiceImpl;
import com.zs6bvr.arduino.code.generator.validators.RequestValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class CodeMakerServiceImplTest {

	@DisplayName("Positive Test BusinessLogicProcessorTest")
	@Test
	void positiveTestValidateBuildProjectRequest() {
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		CodeMakerService service=new CodeMakerServiceImpl();
		DatabaseAdaptor database =new MockDatabaseAdaptorImpl(TestType.PASSING);		
		BusinessLogicProcessor processor=new BusinessLogicProcessor(validator, service,database);
		
		BuildProjectRequest request = makeBuildProjectRequest();
		BuildProjectResponse response = processor.validateRequest(request);
		assertNotNull(response);
		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
	}


	private BuildProjectRequest makeBuildProjectRequest() {
		BuildProjectRequest request = new BuildProjectRequest();
		request.setProjectName("ProjectName");
		request.setFirstModule("FirstModule");
		return request;
	}
}
