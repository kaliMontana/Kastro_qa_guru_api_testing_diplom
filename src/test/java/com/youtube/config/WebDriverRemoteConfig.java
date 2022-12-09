package com.youtube.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:config/remoteLauncher.properties",
		"classpath:config/credentials.properties"
})
public interface WebDriverRemoteConfig extends Config {
	@DefaultValue("chrome")
	String getBrowserName();

	@Key("browser.size")
	String getBrowserSize();

	@Key("base.url")
	String getBaseUrl();

	@Key("api.base.url")
	String getApiBaseUrl();

	@Key("api.base.path")
	String getApiBasePath();

	@Key("api.key")
	String getApiKey();

	@Key("api.service.videos")
	String getApiServiceVideos();

	@Key("api.part")
	String getApiPart();

	@Key("api.word.to.search")
	String getApiWordToSearch();

	@Key("api.video.id")
	String getApiVideoId();
}
