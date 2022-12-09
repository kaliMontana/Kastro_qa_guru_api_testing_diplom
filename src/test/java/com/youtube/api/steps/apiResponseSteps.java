package com.youtube.api.steps;

import com.youtube.data.models.ItemsItem;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

public class apiResponseSteps {
	public static Map<String, String> getVideoInformation(JsonPath jsonPathResponse) {
		Map<String, String> videoInformationList = new HashMap<>();

		ItemsItem[] itemsItem = jsonPathResponse.getObject("items", ItemsItem[].class);

		videoInformationList.put("id", itemsItem[0].getId());
		videoInformationList.put("title", itemsItem[0].getSnippet().getTitle());
		videoInformationList.put("description", itemsItem[0].getSnippet().getDescription());
		videoInformationList.put("channelTitle", itemsItem[0].getSnippet().getChannelTitle());

		return videoInformationList;
	}

}
