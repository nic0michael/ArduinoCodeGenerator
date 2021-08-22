package com.zs6bvr.arduino.code.generator.validators;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RequestValidatorTest {

	@DisplayName("Positive Test RequestValidator")
	@Test
	void positiveTestValidateBuildProjectRequestt() {
		String expectedResponseStatusCode = ResponseStatusCodes.OK.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.OK.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		BuildProjectRequest request = makeBuildProjectRequest();
		BuildProjectResponse response = validator.validateBuildProjectRequest(request);
		assertNotNull(response);
		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
	}
	
	@DisplayName("Negative Test RequestValidator")
	@Test
	void negativeTestValidateBuildProjectRequestt() {
		String expectedResponseStatusCode = ResponseStatusCodes.MISSING_PROJECT_NAME.getResponseStatusCode();
		String expectedResponseStatusMessage = ResponseStatusMessages.MISSING_PROJECT_NAME.getResponseStatusMessage();
		RequestValidator validator = new RequestValidator();
		BuildProjectRequest request = makeBadBuildProjectRequest();
		BuildProjectResponse response = validator.validateBuildProjectRequest(request);
		assertNotNull(response);
		String responseStatusCode = response.getResponseStatusCode();
		String responseStatusMessage = response.getResponseStatusMessage();
		assertEquals(responseStatusMessage, expectedResponseStatusMessage);
		assertEquals(responseStatusCode, expectedResponseStatusCode);
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
// https://mkyong.com/spring-boot/spring-boot-junit-5-mockito/