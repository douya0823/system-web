package com.uaf.service;

import java.util.List;
import java.util.Map;

import com.uaf.bean.ContractInfo;
import com.uaf.bean.ContractModel;
import com.uaf.bean.ContractParam;
import com.uaf.bean.ContractPrintRecord;
import com.uaf.bean.ContractType;
import com.uaf.bean.ContractVersion;
import com.uaf.bean.LoanCity;
import com.uaf.bean.LoanParam;
import com.uaf.bean.LoanProduct;
import com.uaf.bean.SystemInfo;

/**
 * 文件名：LoanParamService.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:11:17
 */
public interface ContractManageServiceService {
	public List<LoanParam> getLoanParamPage(Map<String, Object> param);

	public Integer getLoanParamCount(Map<String, Object> param);

	public void insertLoanParam(Map<String, Object> param);

	public void updateParam(Map<String, Object> param);

	public List<LoanParam> getLoanParamList(Map<String, Object> map);

	public void deleteParam(String id);

	public List<SystemInfo> getSystemInfoPage(Map<String, Object> systemInfo);

	public List<SystemInfo> getSystemInfoList(Map<String, Object> systemInfo);

	public Integer getSystemInfoCount(Map<String, Object> systemInfo);

	public void insertSystemInfo(SystemInfo systemInfo);

	public void updateSystemInfo(SystemInfo systemInfo);

	public void deleteSystemInfo(String id);

	public List<LoanCity> getLoanCityPage(Map<String, Object> loanCity);

	public LoanCity getLoanCityById(Map<String, Object> loanCity);

	public List<LoanCity> getLoanCityList(Map<String, Object> map);

	public Integer getLoanCityCount(Map<String, Object> loanCity);

	public void insertLoanCity(Map<String, Object> loanCity);

	public void updateCity(Map<String, Object> loanCity);

	public void deleteCity(String id);

	public List<LoanProduct> getLoanProductPage(Map<String, Object> product);

	public Integer getLoanProductCount(Map<String, Object> product);

	public void insertLoanProduct(Map<String, Object> product);

	public List<LoanProduct> getProductList(Map<String, Object> map);

	public void updateProduct(Map<String, Object> product);

	public void deleteProduct(String id);

	public List<ContractType> getContractTypePage(Map<String, Object> contractType);

	public Integer getContractTypeCount(Map<String, Object> contractType);

	public void insertContractType(Map<String, Object> contractType);

	public List<ContractType> getContractTypeList(Map<String, Object> map);

	public void updateContractType(Map<String, Object> contractType);

	public void deleteContractType(String id);

	public List<ContractInfo> getContractInfoPage(Map<String, Object> param);

	public Integer getContractInfoCount(Map<String, Object> param);

	public void insertContractInfo(Map<String, Object> param);

	public void updateContractInfo(Map<String, Object> param);

	public void deleteContractInfo(String id);

	public List<ContractInfo> getContractInfoList(Map<String, Object> map);

	public ContractInfo getContractInfoById(Map<String, Object> param);

	public List<ContractParam> getContractParamPage(Map<String, Object> param);

	public List<ContractParam> getContractParamList(Map<String, Object> param);

	public Integer getContractParamCount(Map<String, Object> param);

	public void insertContractParam(Map<String, Object> param);

	public void updateContractParam(Map<String, Object> param);

	public void deleteContractParam(String id);

	public List<ContractVersion> getContractVersionPage(Map<String, Object> param);

	public List<ContractVersion> getContractVersionList(Map<String, Object> param);

	public Integer getContractVersionCount(Map<String, Object> param);

	public void insertContractVersion(Map<String, Object> param);

	public void updateContractVersion(Map<String, Object> param);

	public void deleteContractVersion(String id);

	public List<ContractPrintRecord> getContractPrintRecord(Map<String, Object> record);

	public void insertContractPrintRecord(ContractPrintRecord record);

	public ContractVersion getContractVersionById(Map<String, Object> param);

	public List<ContractModel> getContractModelPage(Map<String, Object> param);

	public List<ContractModel> getContractModelList(Map<String, Object> param);

	public Integer getContractModelCount(Map<String, Object> param);

	public ContractModel getContractModelById(Map<String, Object> param);

	public void insertContractModel(Map<String, Object> param);

	public void updateContractModel(Map<String, Object> param);

	public void deleteContractModel(String id);

	public LoanParam getLoanParamById(Map<String, Object> param);
}
