package com.uaf.bean;

/**
 * 文件名：SystemInfo.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月31日上午10:16:55
 */
public class SystemInfo {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SystemInfo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public SystemInfo() {
	}
	
}
