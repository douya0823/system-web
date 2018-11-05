package com.uaf.bean;

/**
 * 文件名：ContractVersion.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月30日下午1:54:29
 */
public class ContractVersion {
	private String id;
	private ContractInfo contractInfo;
	private String version;
	private String url;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContractInfo getContractInfo() {
		return contractInfo;
	}

	public void setContractInfo(ContractInfo contractInfo) {
		this.contractInfo = contractInfo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ContractVersion(String id, ContractInfo contractInfo, String version, String url, String status) {
		super();
		this.id = id;
		this.contractInfo = contractInfo;
		this.version = version;
		this.url = url;
		this.status = status;
	}

	public ContractVersion() {
	}

}
