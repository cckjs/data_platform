package com.yy.data.platform.weibo.sdk;

import java.util.List;

public class WeiboData {

	private User user;
	
	private List<Status> weibos;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Status> getWeibos() {
		return weibos;
	}

	public void setWeibos(List<Status> weibos) {
		this.weibos = weibos;
	}
	
	
}
