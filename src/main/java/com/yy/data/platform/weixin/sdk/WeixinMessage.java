package com.yy.data.platform.weixin.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class WeixinMessage {

	private String batchId;
	
	private Date crawlTime;

	private List<WeixinData> data;
	
	public List<WeixinData> getData() {
		return data;
	}

	public void setData(List<WeixinData> data) {
		this.data = data;
	}

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
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		WeixinMessage message = new  WeixinMessage();
		message.setBatchId(System.currentTimeMillis()+"");
		message.setCrawlTime(new Date());
		List<WeixinData> datas = new ArrayList<WeixinData>();
		WeixinData data1 = new WeixinData();
		WeixinUser user1 = new WeixinUser();
		user1.setCreatedAt(new Date());
		user1.setUserId("xinhuawang");
		user1.setUserName("新华网");
		data1.setUser(user1);
		List<WeixinContent> contents = new ArrayList<WeixinContent>();
		WeixinContent content1 = new WeixinContent();
		content1.setAuthor("新华网");
		content1.setContent("文本内容");
		content1.setContent_source_url("原文链接");
		content1.setDigest("内容简介");
		content1.setTitle("内容标题");
		content1.setType("内容类型");
		contents.add(content1);
		data1.setWeixin(contents);
		datas.add(data1);
		message.setData(datas);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(message));
	}
}
