package com.uaf.bean;

/**
 * 文件名：ContractInfo.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月30日下午1:46:47
 */
public class ContractInfo {
	private String contractId;
	private String contractCode;
	private ContractType contractType;
	private LoanCity city;
	private LoanProduct product;
	private ContractModel contractModel;
	private SystemInfo systemInfo;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public LoanProduct getProduct() {
		return product;
	}

	public void setProduct(LoanProduct product) {
		this.product = product;
	}

	public LoanCity getCity() {
		return city;
	}

	public void setCity(LoanCity city) {
		this.city = city;
	}

	public ContractInfo(String contractId, String contractCode, ContractType contractType, LoanCity city,
			LoanProduct product, ContractModel contractModel, SystemInfo systemInfo) {
		super();
		this.contractId = contractId;
		this.contractCode = contractCode;
		this.contractType = contractType;
		this.city = city;
		this.product = product;
		this.contractModel = contractModel;
		this.setSystemInfo(systemInfo);
	}

	public ContractInfo() {
	}

	public ContractModel getContractModel() {
		return contractModel;
	}

	public void setContractModel(ContractModel contractModel) {
		this.contractModel = contractModel;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

}
