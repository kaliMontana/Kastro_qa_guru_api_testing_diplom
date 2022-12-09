package com.youtube.api.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.youtube.apiTests.TestSetup.apiBasePath;
import static com.youtube.apiTests.TestSetup.apiBaseUrl;

public class BaseApiSteps {

	static RequestSpecification getRequestSpecifications() {
		return new RequestSpecBuilder()
				.setBaseUri(apiBaseUrl)
				.setBasePath(apiBasePath)
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.build();
	}
}
