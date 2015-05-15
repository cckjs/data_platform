/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
 * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.yy.data.platform.weibo.sdk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * A data class representing Basic user information element
 */
public class User {

	private String id; // 用户UID
	private String screenName; // 微博昵称
	private String name; // 友好显示名称，如Bill Gates,名称中间的空格正常显示(此特性暂不支持)
	private String province; // 省份编码（参考省份编码表）
	private String city; // 城市编码（参考城市编码表）
	private String location; // 地址
	private String description; // 个人描述
	private String url; // 用户博客地址
	private String profileImageUrl; // 自定义图像
	private String userDomain; // 用户个性化URL
	private String gender; // 性别,m--男，f--女,n--未知
	private int followersCount; // 粉丝数
	private int friendsCount; // 关注数
	private int statusesCount; // 微博数
	private int favouritesCount; // 收藏数
	private Date createdAt; // 创建时间

	private boolean verified; // 加V标示，是否微博认证用户
	private int verifiedType; // 认证类型

	private String avatarLarge; // 大头像地址

	private int biFollowersCount; // 互粉数

	private String lang; // 用户语言版本
	private String verifiedReason; // 认证原因
	private String weihao; // 微號
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public String getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	public int getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}
	public int getStatusesCount() {
		return statusesCount;
	}
	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}
	public int getFavouritesCount() {
		return favouritesCount;
	}
	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public int getVerifiedType() {
		return verifiedType;
	}
	public void setVerifiedType(int verifiedType) {
		this.verifiedType = verifiedType;
	}
	public String getAvatarLarge() {
		return avatarLarge;
	}
	public void setAvatarLarge(String avatarLarge) {
		this.avatarLarge = avatarLarge;
	}
	public int getBiFollowersCount() {
		return biFollowersCount;
	}
	public void setBiFollowersCount(int biFollowersCount) {
		this.biFollowersCount = biFollowersCount;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getVerifiedReason() {
		return verifiedReason;
	}
	public void setVerifiedReason(String verifiedReason) {
		this.verifiedReason = verifiedReason;
	}
	public String getWeihao() {
		return weihao;
	}
	public void setWeihao(String weihao) {
		this.weihao = weihao;
	}

	
}
