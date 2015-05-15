package com.yy.data.platform.weibo.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class WeiboMessage {

	private String batchId;
	
	private Date crawlTime;
	
	private List<WeiboData> weibodata;

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

	public List<WeiboData> getWeibodata() {
		return weibodata;
	}

	public void setWeibodata(List<WeiboData> weibodata) {
		this.weibodata = weibodata;
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WeiboMessage message = new WeiboMessage();
		List<WeiboData> datas = new ArrayList<WeiboData>();
		WeiboData data1 = new WeiboData();
		User user1 = new User();
		user1.setAvatarLarge("http://avatar");
		user1.setBiFollowersCount(100);
		user1.setCity("北京");
		user1.setCreatedAt(new Date());
		user1.setDescription("简介");
		user1.setFavouritesCount(200);
		user1.setFollowersCount(300);
		user1.setFriendsCount(400);
		user1.setGender("f");
		user1.setId("100000");
		user1.setLang("zh");
		user1.setLocation("北京 海淀区");
		user1.setName("人生如梦");
		user1.setProfileImageUrl("http://www.weibo.com");
		user1.setProvince("北京");
		user1.setScreenName("人生如梦啊");
		user1.setStatusesCount(1000);
		user1.setUrl("http://blog.sina.com");
		user1.setUserDomain("http://www.weibo.com/renshengrumeng");
		user1.setVerified(true);
		user1.setVerifiedReason("人生如梦发展有限公司ceo");
		user1.setVerifiedType(1);
		user1.setWeihao("10000");
		data1.setUser(user1);
		List<Status> status = new ArrayList<Status>();
		Status status1 = new Status();
		status1.setAttitudes_count(100);
		status1.setBmiddlePic("http://pic.sina.com/1");
		status1.setCommentsCount(1000);
		status1.setCreatedAt(new Date());
		status1.setMid("12310999991913");
		status1.setOriginalPic("http://pic.sina.com/1");
		status1.setRepostsCount(2000);
		status1.setSource("网页版");
		status1.setText("转发微博");
		status1.setThumbnailPic("http://pic.sina.com/1");
		Geos geo = new Geos();
		geo.setAddress("北京市朝阳区XXX");
		geo.setCity("北京");
		geo.setCityName("北京");
		geo.setLatitude("55");
		geo.setLongitude("55");
		geo.setPinyin("BJ");
		geo.setProvince("北京");
		geo.setProvinceName("北京");
		status1.setGeo(geo);
		status.add(status1);
		
		data1.setWeibos(status);
		datas.add(data1);
		message.setWeibodata(datas);
		message.setBatchId(System.currentTimeMillis()+"");
		message.setCrawlTime(new Date());
		System.out.println(mapper.writeValueAsString(message));
	}
}
