package com.uaf.bean;

/**
 * 文件名：ContractParam.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月30日下午1:50:05
 */
public class ContractParam {
	private String id;
	private ContractModel contractModel;
	private LoanParam param;

	public ContractModel getContractInfo() {
		return contractModel;
	}

	public void setContractModel(ContractModel contractModel) {
		this.contractModel = contractModel;
	}

	public LoanParam getParam() {
		return param;
	}

	public void setParam(LoanParam param) {
		this.param = param;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContractModel getContractModel() {
		return contractModel;
	}

	public ContractParam() {
	}

	public ContractParam(String id, ContractModel contractModel, LoanParam param) {
		super();
		this.id = id;
		this.contractModel = contractModel;
		this.param = param;
	}

}
