package com.uaf.bean;

/**
 * 文件名：LoanCicy.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月30日下午1:40:25
 */
public class LoanCity {
	private String id;
	private String code;
	private String name;
	private SystemInfo systemInfo;

	public LoanCity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LoanCity(String id, String code, String name, SystemInfo systemInfo) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.systemInfo = systemInfo;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

}
