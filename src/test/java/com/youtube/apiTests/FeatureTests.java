package com.youtube.apiTests;

import com.youtube.Pages.BeforeYouContinuePage;
import com.youtube.Pages.MainPage;
import com.youtube.Pages.ResultPage;
import com.youtube.Pages.WatchPage;
import com.youtube.api.steps.FeatureApiSteps;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Tag("AllTests")
@Owner("Kastro B.")
@Link("https://youtube.com")
@Story("Api and frontend Youtube video information")
public class FeatureTests extends TestSetup {
	FeatureApiSteps featurePages = new FeatureApiSteps();
	MainPage mainPage = new MainPage();
	ResultPage resultPage = new ResultPage();
	WatchPage watchPage = new WatchPage();
	BeforeYouContinuePage beforeYouContinuePage = new BeforeYouContinuePage();


	@Test
	@Tag("api")
	public void videoInformationTest() {
		Map<String, String> VideoInformationResponse = featurePages.callGetVideoInformationApiStep();

		mainPage.openMainPageStep();

		beforeYouContinuePage.clickOnRejectAllStep();

		mainPage.searchStep();
		mainPage.checkExistenceWordInResultStep();
		mainPage.clickOnFirstResultFromList();

		resultPage.clickOnVideoTitle();

		String videoTitleFromSite = watchPage.getVideoTitle();
		String channelTitleFromSite = watchPage.getChannelTitle();
		String tabTitleFromSite = watchPage.getTabName();
		String descriptionFromSite = watchPage.getDescription();
		String videoIdFromSite = watchPage.getVideoId();

		featurePages.checkInformation(
				VideoInformationResponse,
				videoTitleFromSite,
				channelTitleFromSite,
				tabTitleFromSite,
				descriptionFromSite,
				videoIdFromSite
		);
	}
}
