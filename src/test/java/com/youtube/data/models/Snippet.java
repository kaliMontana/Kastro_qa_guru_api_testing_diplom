package com.youtube.data.models;

import lombok.Data;

@Data
public class Snippet {
	private String publishTime;
	private String description;
	private String title;
	private String channelId;
	private String channelTitle;
}