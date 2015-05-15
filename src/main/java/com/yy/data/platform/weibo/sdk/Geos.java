package com.yy.data.platform.weibo.sdk;

/**
 * 地理信息
 * 
 * @author xiaoV
 * 
 */
public class Geos {

	private String longitude; // 经度坐标
	private String latitude; // 维度坐标
	private String city; // 所在城市的城市代码
	private String province; // 所在省份的省份代码
	private String cityName; // 所在城市的城市名称
	private String provinceName;// 所在省份的省份名称
	private String address; // 所在的实际地址，可以为空
	private String pinyin; // 地址的汉语拼音，不是所有情况都会返回该字段

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

}
