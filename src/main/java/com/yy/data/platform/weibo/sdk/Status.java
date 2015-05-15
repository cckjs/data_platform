package com.yy.data.platform.weibo.sdk;

import java.util.Date;

public class Status {

	private Date createdAt; // status创建时间
	private String mid; // 微博MID
	private String text; // 微博内容
	private String source; // 微博来源
	private String thumbnailPic; // 微博内容中的图片的缩略地址
	private String bmiddlePic; // 中型图片
	private String originalPic; // 原始图片
	private Geos geo; // 地理信息，保存经纬度，没有时不返回此字段
	private int repostsCount; // 转发数
	private int commentsCount; // 评论数
	private int attitudes_count;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getThumbnailPic() {
		return thumbnailPic;
	}

	public void setThumbnailPic(String thumbnailPic) {
		this.thumbnailPic = thumbnailPic;
	}

	public String getBmiddlePic() {
		return bmiddlePic;
	}

	public void setBmiddlePic(String bmiddlePic) {
		this.bmiddlePic = bmiddlePic;
	}

	public String getOriginalPic() {
		return originalPic;
	}

	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}

	public int getRepostsCount() {
		return repostsCount;
	}

	public void setRepostsCount(int repostsCount) {
		this.repostsCount = repostsCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSource() {
		return source;
	}

	public Geos getGeo() {
		return geo;
	}

	public void setGeo(Geos geo) {
		this.geo = geo;
	}

	public int getAttitudes_count() {
		return attitudes_count;
	}

	public void setAttitudes_count(int attitudes_count) {
		this.attitudes_count = attitudes_count;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
