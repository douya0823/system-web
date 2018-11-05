package com.uaf.bean;

/**
 * 文件名：ContractModel.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年8月23日上午9:17:14
 */
public class ContractModel {
	private String id;
	private String name;
	private String version;
	private String url;
	private ContractType contractType;
	private SystemInfo systemInfo;

	public ContractModel(String id, String name, String version, String url, ContractType contractType,
			SystemInfo systemInfo) {
		this.id = id;
		this.name = name;
		this.version = version;
		this.url = url;
		this.contractType = contractType;
	}

	public ContractModel() {
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

}
