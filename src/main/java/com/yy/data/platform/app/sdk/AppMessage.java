package com.yy.data.platform.app.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.yy.data.platform.weixin.sdk.WeixinContent;
import com.yy.data.platform.weixin.sdk.WeixinData;
import com.yy.data.platform.weixin.sdk.WeixinMessage;
import com.yy.data.platform.weixin.sdk.WeixinUser;

public class AppMessage {

	private String batchId;

	private Date crawlTime;
	
	private List<AppData> data;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Date getCrawlTime() {
		return crawlTime;
	}

	public void setCrawlTime(Date crawlTime) {
		this.crawlTime = crawlTime;
	}

	public List<AppData> getData() {
		return data;
	}

	public void setData(List<AppData> data) {
		this.data = data;
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		AppMessage message = new  AppMessage();
		message.setBatchId(System.currentTimeMillis()+"");
		message.setCrawlTime(new Date());
		List<AppData> datas = new ArrayList<AppData>();
		AppData data1 = new AppData();
		AppUser user1 = new AppUser();
		user1.setAppDesc("app简介");
		user1.setAppId("appId");
		user1.setAppMainPage("首页url");
		user1.setAppName("app名称");
		data1.setUser(user1);
		List<AppContent> contents = new ArrayList<AppContent>();
		AppContent content1 = new AppContent();
		content1.setAuthor("新华网");
		content1.setContent("文本内容");
		content1.setContent_source_url("原文链接");
		content1.setDigest("内容简介");
		content1.setTitle("内容标题");
		content1.setCreatedAt(new Date());
		contents.add(content1);
		data1.setContents(contents);
		datas.add(data1);
		message.setData(datas);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(message));
	}
}
