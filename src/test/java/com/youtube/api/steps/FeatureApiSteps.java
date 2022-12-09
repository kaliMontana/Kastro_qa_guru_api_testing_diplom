package com.youtube.api.steps;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;

import static com.youtube.api.steps.BaseApiSteps.getRequestSpecifications;
import static com.youtube.api.steps.apiResponseSteps.getVideoInformation;
import static com.youtube.apiTests.TestSetup.*;
import static com.youtube.helpers.Attach.attachToAllureJsonPathResponse;
import static com.youtube.helpers.Helper.format;
import static com.youtube.helpers.api.GetRequest.doHttpGetRequest;

public class FeatureApiSteps {
	private final String videoInformationQuery = "{}?part={}&id={}&key={}";


	@Step("Get video information by api query")
	public Map<String, String> callGetVideoInformationApiStep() {
		String query = format(videoInformationQuery, apiServiceVideos, apiPart, apiVideoId, apiKey);

		JsonPath jsonPath = doHttpGetRequest(
				getRequestSpecifications(),
				query
		);

		attachToAllureJsonPathResponse(apiBaseUrl + apiBasePath + query, jsonPath);

		return getVideoInformation(jsonPath);
	}

	@Step("check the video information from site and api response")
	public void checkInformation(
			Map<String, String> information,
			String videoTitle,
			String channelTitle,
			String tabTitle,
			String description,
			String videoId
	) {
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(information.get("title"))
				.as("The titles are not  equal")
				.isEqualTo(videoTitle);
		softly.assertThat(information.get("id"))
				.as("The video ids are not  equal")
				.isEqualTo(videoId);
		softly.assertThat(information.get("channelTitle"))
				.as("The channelTitle are not  equal")
				.isEqualTo(channelTitle);
		softly.assertThat(tabTitle)
				.as("Error in the tabs name")
				.contains(information.get("title"));
		softly.assertThat(information.get("description"))
				.as("The video not contains description")
				.isNotEqualTo("");
		softly.assertThat(description)
				.as("The video not contains description")
				.isNotEqualTo("");

		softly.assertAll();
	}
}
