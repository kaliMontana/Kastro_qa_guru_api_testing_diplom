package com.youtube.helpers.api;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetRequest {
	public static JsonPath doHttpGetRequest(
			RequestSpecification requestSpec,
			String queryParams
	) {
		return new JsonPath(
				given()
						.log().uri()
						.spec(requestSpec)
						.when()
						.get(queryParams)
						.then()
						.log().status()
						//.log().body()
						.statusCode(200)
						.extract().response().getBody().jsonPath().prettify()
		);
	}
}
