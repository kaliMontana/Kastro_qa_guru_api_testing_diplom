package com.youtube.data.models;

import lombok.Data;

@Data
public class ItemsItem {
	private Snippet snippet;
	private String kind;
	private String etag;
	private String id;
}