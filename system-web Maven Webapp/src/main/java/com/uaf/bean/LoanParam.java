package com.uaf.bean;

/**
 * 文件名：LoanParam.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:17:49
 */
public class LoanParam {
	private String id;
	private LoanParam pId;
	private String name;
	private String description;
	private SystemInfo systemInfo;

	public LoanParam() {

	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	public LoanParam getPId() {
		return pId;
	}

	public void setPId(LoanParam pId) {
		this.pId = pId;
	}

	public LoanParam(String id, LoanParam pId, String name, String description, SystemInfo systemInfo) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.description = description;
		this.systemInfo = systemInfo;
	}



}
