package com.yy.data.platform.weixin.sdk;

import java.util.List;

public class WeixinData {

	private WeixinUser user;
	
	private List<WeixinContent> weixin;

	public WeixinUser getUser() {
		return user;
	}

	public void setUser(WeixinUser user) {
		this.user = user;
	}

	public List<WeixinContent> getWeixin() {
		return weixin;
	}

	public void setWeixin(List<WeixinContent> weixin) {
		this.weixin = weixin;
	}
}
