package com.youtube.apiTests;

import com.codeborne.selenide.Configuration;
import com.youtube.config.WebDriverRemoteConfig;
import com.youtube.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestSetup {
	private static WebDriverRemoteConfig config = ConfigFactory.create(WebDriverRemoteConfig.class);
	private static final String baseUrl = config.getBaseUrl();
	private static final String browserName = config.getBrowserName();
	private static final String browserSize = config.getBrowserSize();

	public static final String apiBaseUrl = config.getApiBaseUrl();
	public static final String apiBasePath = config.getApiBasePath();
	public static final String apiKey = config.getApiKey();
	public static final String apiPart = config.getApiPart();
	public static final String searchedWord = config.getApiWordToSearch();
	public static final String apiServiceVideos = config.getApiServiceVideos();
	public static final String apiVideoId = config.getApiVideoId();


	@BeforeAll
	static void setup() {
		Configuration.baseUrl = baseUrl;
		Configuration.browserSize = browserSize;
		Configuration.browser = browserName;
	}

	@AfterEach
	void addAttachments() {
		Attach.screenshotAs("Youtube test screenshot");
		Attach.pageSource();
		Attach.addVideo();

		closeWebDriver();
	}
}
