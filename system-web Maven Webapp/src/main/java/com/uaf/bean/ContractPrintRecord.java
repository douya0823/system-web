package com.uaf.bean;

/**
 * 文件名：ContractPrintRecord.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月31日上午10:17:53
 */
public class ContractPrintRecord {
	private String systemId;
	private String contractVersionId;
	
	/* 客源方 */
	private String source;
	
	/* 合作方 */
	private String partner;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getContractVersionId() {
		return contractVersionId;
	}

	public void setContractVersionId(String contractVersionId) {
		this.contractVersionId = contractVersionId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public ContractPrintRecord(String systemId, String contractVersionId, String source, String partner) {
		super();
		this.systemId = systemId;
		this.contractVersionId = contractVersionId;
		this.source = source;
		this.partner = partner;
	}

	public ContractPrintRecord() {
	}

}
