package com.youtube.Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static com.youtube.apiTests.TestSetup.searchedWord;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class MainPage {
	private final SelenideElement searchInputElement = $("#search-input");
	private final SelenideElement searchElement = $("#search");
	private final ElementsCollection itemListElement = $$(".sbse");


	@Step("Open main site")
	public void openMainPageStep() {
		open("");
	}

	@Step("Search 'Appium'")
	public void searchStep() {
		searchInputElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).click();
		searchInputElement.find(By.id("search")).setValue(searchedWord);
	}

	@Step("Check the searched word in the result pop-up list")
	public void checkExistenceWordInResultStep() {
		itemListElement.shouldHave(CollectionCondition.sizeGreaterThan(0));

		SoftAssertions softAssertions = new SoftAssertions();

		itemListElement.forEach(x -> softAssertions.assertThat(x.getText())
				.as("Result element does not contains searched word")
				.containsIgnoringCase(searchedWord));

		softAssertions.assertAll();
	}

	@Step("Click on first word in the result pop-up list")
	public void clickOnFirstResultFromList() {
		itemListElement.first().shouldHave(Condition.text(searchedWord)).click();
	}
}
