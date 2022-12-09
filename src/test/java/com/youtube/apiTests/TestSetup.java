package com.youtube.apiTests;

import com.codeborne.selenide.Configuration;
import com.youtube.config.WebDriverRemoteConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestSetup {
	private static WebDriverRemoteConfig config = ConfigFactory.create(WebDriverRemoteConfig.class);
	private static final String baseUrl = config.getBaseUrl();
	private static final String browserName = config.getBrowserName();
	private static final String browserSize = config.getBrowserSize();

	public static final String apiBaseUrl = config.getApiBaseUrl();
	public static final String apiBasePath = config.getApiBasePath();
	public static final String apiKey = config.getApiKey();
	public static final String apiServiceSearch = config.getApiServiceSearch();
	public static final String apiPart = config.getApiPart();
	public static final String maxResults = config.getApiMaxResults();
	public static final String qSearch = config.getApiWordToSearch();
	public static final String apiType = config.getApiType();
	public static final String apiServiceVideos = config.getApiServiceVideos();
	public static final String apiVideoId = config.getApiVideoId();


	@BeforeAll
	static void setup() {
		System.out.println("baseUrl " + baseUrl);
		Configuration.baseUrl = baseUrl;
		Configuration.browserSize = browserSize;
		Configuration.browser = browserName;
	}
}
