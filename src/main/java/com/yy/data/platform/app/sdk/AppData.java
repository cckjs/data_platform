package com.yy.data.platform.app.sdk;

import java.util.List;

public class AppData {

	private AppUser user;
	
	private List<AppContent> contents;

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public List<AppContent> getContents() {
		return contents;
	}

	public void setContents(List<AppContent> contents) {
		this.contents = contents;
	}
	
	
}
