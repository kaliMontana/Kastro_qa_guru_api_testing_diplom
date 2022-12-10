package com.youtube.helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.youtube.helpers.Helper.format;

public class Attach {
	private static final String TEXT_PLAIN_TYPE = "text/plain";
	private static final String TEXT_HTML_TYPE = "text/html";
	private static final String TEXT_JSON_TYPE = "text/json";
	private static final String IMAGE_PNG_TYPE = "image/png";
	private static final String APPLICATION_JSON_TYPE = "application/json";


	@Attachment(value = "{attachName}", type = TEXT_PLAIN_TYPE)
	public static String attachAsText(String attachName, String message) {
		return message;
	}

	@Attachment(value = "Page source", type = TEXT_HTML_TYPE)
	public static byte[] pageSource() {
		return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
	}

	@Attachment(value = "{attachName}", type = IMAGE_PNG_TYPE)
	public static byte[] screenshotAs(String attachName) {
		return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "Video", type = TEXT_HTML_TYPE, fileExtension = ".html")
	public static String addVideo() {
		return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
				+ getVideoUrl(getSessionId())
				+ "' type='video/mp4'></video></body></html>";
	}

	public static URL getVideoUrl(String sessionId) {
		String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";

		try {
			return new URL(videoUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSessionId() {
		return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
	}

	public static void attachToAllureObjectWithToJson(String attachName, Object object) {
		Allure.addAttachment(
				attachName,
				APPLICATION_JSON_TYPE,
				object.toString()
		);
	}

	public static void attachToAllureJsonPathResponse(String requestUrl, JsonPath jsonPath) {
		attachToAllureJsonPathWithPrettify(
				format("Response body - \"{}\"", requestUrl),
				jsonPath
		);
	}

	public static void attachToAllureJsonPathWithPrettify(String attachName, JsonPath jsonPath) {
		Allure.addAttachment(
				attachName,
				TEXT_JSON_TYPE,
				jsonPath.prettify()
		);
	}
}
