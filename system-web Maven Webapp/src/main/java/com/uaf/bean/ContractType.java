package com.uaf.bean;

/**
 * 文件名：ContractType.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月30日下午1:39:17
 */
public class ContractType {
	private String id;
	private String name;
	private String code;
	private SystemInfo systemInfo;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	public ContractType(String id, String name, String code, SystemInfo systemInfo) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.systemInfo = systemInfo;
	}

	public ContractType() {
	}

}
