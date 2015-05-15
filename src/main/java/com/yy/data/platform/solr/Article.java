package com.yy.data.platform.solr;

import java.util.List;

public class Article {

	private String id;

	private String title;

	private String content;

	private List<String> contentHightLights;

	public List<String> getContentHightLights() {
		return contentHightLights;
	}

	public void setContentHightLights(List<String> contentHightLights) {
		this.contentHightLights = contentHightLights;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
