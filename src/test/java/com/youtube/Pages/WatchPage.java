package com.youtube.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.youtube.helpers.Waiting.EIGHT_SEC;

public class WatchPage {
	public final SelenideElement itemTitleElement = $x("//div[@id = 'title']//h1//yt-formatted-string");
	public final SelenideElement itemChannelTitleElement = $x("//div[@id = 'owner']//div[@id='text-container']//a");
	public final SelenideElement itemDescriptionElement = $x("//ytd-text-inline-expander//yt-formatted-string//span");
	public final SelenideElement videoIdElement = $x("//ytd-watch-metadata[contains(@class, 'watch-active-metadata')]");


	@Step("Get video title")
	public String getVideoTitle() {
		return itemTitleElement.shouldBe(visible, Duration.ofSeconds(EIGHT_SEC.getValue())).getText();
	}

	@Step("Get channel title")
	public String getChannelTitle() {
		return itemChannelTitleElement.shouldBe(visible, Duration.ofSeconds(EIGHT_SEC.getValue())).getText();
	}

	@Step("Get tab name")
	public String getTabName() {
		return Selenide.switchTo().window(0).getTitle();
	}

	@Step("Get video description")
	public String getDescription() {
		return itemDescriptionElement.getText();
	}

	@Step("Get video id")
	public String getVideoId() {
		return videoIdElement.getAttribute("video-id");
	}
}
