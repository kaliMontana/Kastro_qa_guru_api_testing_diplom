package com.youtube.Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.youtube.config.WebDriverRemoteConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$$x;

public class ResultPage {
	private final ElementsCollection itemListElement2 = $$x("//a[@id='video-title' and @href]");

	private static WebDriverRemoteConfig config = ConfigFactory.create(WebDriverRemoteConfig.class);


	@Step("Click on video title")
	public void clickOnVideoTitle() {
		itemListElement2.shouldHave(CollectionCondition.sizeGreaterThan(0));
		itemListElement2.find(Condition.href(config.getApiVideoId())).click();
	}
}
