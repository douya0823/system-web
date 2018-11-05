package com.uaf.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.uaf.dao.ContractInfoDao;
import com.uaf.dao.ContractModelDao;
import com.uaf.dao.ContractParamDao;
import com.uaf.dao.ContractPrintRecordDao;
import com.uaf.dao.ContractTypeDao;
import com.uaf.dao.ContractVersionDao;
import com.uaf.dao.LoanCityDao;
import com.uaf.dao.LoanParamDao;
import com.uaf.dao.LoanProductDao;
import com.uaf.dao.SystemInfoDao;
import com.uaf.service.ContractManageServiceService;

/**
 * 文件名：LoanParamServiceImpl.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:12:07
 */
@Service("contractManageService")
public class ContractManageServiceImpl implements ContractManageServiceService {

	@Autowired
	private LoanParamDao paramsDao;
	@Autowired
	private LoanCityDao loanCityDao;
	@Autowired
	private LoanProductDao loanProductDao;
	@Autowired
	private SystemInfoDao systemInfoDao;
	@Autowired
	private ContractTypeDao contractTypeDao;
	@Autowired
	private ContractInfoDao contractInfoDao;
	@Autowired
	private ContractParamDao contractParamDao;
	@Autowired
	private ContractVersionDao contractVersionDao;
	@Autowired
	private ContractPrintRecordDao contractPrintRecordDao;
	@Autowired
	private ContractModelDao contractModelDao;

	@Override
	public List<LoanParam> getLoanParamPage(Map<String, Object> param) {
		return paramsDao.getLoanParamPage(param);
	}

	@Override
	public Integer getLoanParamCount(Map<String, Object> param) {
		return paramsDao.getLoanParamCount(param);
	}

	@Override
	public void insertLoanParam(Map<String, Object> param) {
		paramsDao.insertLoanParam(param);
	}

	@Override
	public List<LoanParam> getLoanParamList(Map<String, Object> map) {
		return paramsDao.getLoanParamList(map);
	}

	@Override
	public List<SystemInfo> getSystemInfoPage(Map<String, Object> systemInfo) {
		return systemInfoDao.getSystemInfoPage(systemInfo);
	}

	@Override
	public Integer getSystemInfoCount(Map<String, Object> systemInfo) {
		return systemInfoDao.getSystemInfoCount(systemInfo);
	}

	@Override
	public void insertSystemInfo(SystemInfo systemInfo) {
		systemInfoDao.insertSystemInfo(systemInfo);

	}

	@Override
	public List<LoanCity> getLoanCityPage(Map<String, Object> loanCity) {
		return loanCityDao.getLoanCityPage(loanCity);
	}

	@Override
	public LoanCity getLoanCityById(Map<String, Object> loanCity) {
		return loanCityDao.getLoanCityById(loanCity);
	}

	@Override
	public List<LoanCity> getLoanCityList(Map<String, Object> map) {
		return loanCityDao.getLoanCityList(map);
	}

	@Override
	public Integer getLoanCityCount(Map<String, Object> loanCity) {
		return loanCityDao.getLoanCityCount(loanCity);
	}

	@Override
	public void insertLoanCity(Map<String, Object> loanCity) {
		loanCityDao.insertLoanCity(loanCity);
	}

	@Override
	public void updateCity(Map<String, Object> loanCity) {
		loanCityDao.updateCity(loanCity);
	}

	@Override
	public void deleteCity(String id) {
		loanCityDao.deleteCity(id);
	}

	@Override
	public List<LoanProduct> getLoanProductPage(Map<String, Object> product) {
		return loanProductDao.getLoanProductPage(product);
	}

	@Override
	public Integer getLoanProductCount(Map<String, Object> product) {
		return loanProductDao.getLoanProductCount(product);
	}

	@Override
	public void insertLoanProduct(Map<String, Object> product) {
		loanProductDao.insertLoanProduct(product);
	}

	@Override
	public List<LoanProduct> getProductList(Map<String, Object> map) {
		return loanProductDao.getProductList(map);
	}

	@Override
	public List<ContractType> getContractTypePage(Map<String, Object> contractType) {
		return contractTypeDao.getContractTypePage(contractType);
	}

	@Override
	public Integer getContractTypeCount(Map<String, Object> contractType) {
		return contractTypeDao.getContractTypeCount(contractType);
	}

	@Override
	public void insertContractType(Map<String, Object> contractType) {
		contractTypeDao.insertContractType(contractType);
	}

	@Override
	public List<ContractType> getContractTypeList(Map<String, Object> map) {
		return contractTypeDao.getContractTypeList(map);
	}

	@Override
	public List<ContractInfo> getContractInfoPage(Map<String, Object> param) {
		return contractInfoDao.getContractInfoPage(param);
	}

	@Override
	public Integer getContractInfoCount(Map<String, Object> param) {
		return contractInfoDao.getContractInfoCount(param);
	}

	@Override
	public void insertContractInfo(Map<String, Object> param) {
		contractInfoDao.insertContractInfo(param);
	}

	@Override
	public List<ContractInfo> getContractInfoList(Map<String, Object> map) {
		return contractInfoDao.getContractInfoList(map);
	}

	@Override
	public List<ContractParam> getContractParamPage(Map<String, Object> param) {
		return contractParamDao.getContractParamPage(param);
	}

	@Override
	public Integer getContractParamCount(Map<String, Object> param) {
		return contractParamDao.getContractParamCount(param);
	}

	@Override
	public void insertContractParam(Map<String, Object> param) {
		contractParamDao.insertContractParam(param);
	}

	@Override
	public List<ContractVersion> getContractVersionPage(Map<String, Object> param) {
		return contractVersionDao.getContractVersionPage(param);
	}

	@Override
	public Integer getContractVersionCount(Map<String, Object> param) {
		return contractVersionDao.getContractVersionCount(param);
	}

	@Override
	public void insertContractVersion(Map<String, Object> param) {
		contractVersionDao.insertContractVersion(param);
	}

	@Override
	public List<ContractPrintRecord> getContractPrintRecord(Map<String, Object> record) {
		return contractPrintRecordDao.getContractPrintRecord(record);
	}

	@Override
	public void insertContractPrintRecord(ContractPrintRecord record) {
		contractPrintRecordDao.insertContractPrintRecord(record);
	}

	@Override
	public void updateParam(Map<String, Object> param) {
		paramsDao.updateParam(param);
	}

	@Override
	public void deleteParam(String id) {
		paramsDao.deleteParam(id);
	}

	@Override
	public void updateSystemInfo(SystemInfo systemInfo) {
		systemInfoDao.updateSystemInfo(systemInfo);
	}

	@Override
	public void deleteSystemInfo(String id) {
		systemInfoDao.deleteSystemInfo(id);
	}

	@Override
	public void updateProduct(Map<String, Object> product) {
		loanProductDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(String id) {
		loanProductDao.deleteProduct(id);
	}

	@Override
	public void updateContractType(Map<String, Object> contractType) {
		contractTypeDao.updateContractType(contractType);
	}

	@Override
	public void deleteContractType(String id) {
		contractTypeDao.deleteContractType(id);
	}

	@Override
	public void updateContractInfo(Map<String, Object> param) {
		contractInfoDao.updateContractInfo(param);
	}

	@Override
	public void deleteContractInfo(String id) {
		contractInfoDao.deleteContractInfo(id);
	}

	@Override
	public void updateContractParam(Map<String, Object> param) {
		contractParamDao.updateContractParam(param);
	}

	@Override
	public void deleteContractParam(String id) {
		contractParamDao.deleteContractParam(id);
	}

	@Override
	public void updateContractVersion(Map<String, Object> param) {
		contractVersionDao.updateContractVersion(param);
	}

	@Override
	public void deleteContractVersion(String id) {
		contractVersionDao.deleteContractVersion(id);
	}

	@Override
	public ContractInfo getContractInfoById(Map<String, Object> param) {
		return contractInfoDao.getContractInfoById(param);
	}

	@Override
	public ContractVersion getContractVersionById(Map<String, Object> param) {
		return contractVersionDao.getContractVersionById(param);
	}

	@Override
	public List<ContractParam> getContractParamList(Map<String, Object> param) {
		return contractParamDao.getContractParamList(param);
	}

	@Override
	public List<ContractVersion> getContractVersionList(Map<String, Object> param) {
		return contractVersionDao.getContractVersionList(param);
	}

	@Override
	public List<ContractModel> getContractModelPage(Map<String, Object> param) {
		return contractModelDao.getContractModelPage(param);
	}

	@Override
	public List<ContractModel> getContractModelList(Map<String, Object> param) {
		return contractModelDao.getContractModelList(param);
	}

	@Override
	public Integer getContractModelCount(Map<String, Object> param) {
		return contractModelDao.getContractModelCount(param);
	}

	@Override
	public ContractModel getContractModelById(Map<String, Object> param) {
		return contractModelDao.getContractModelById(param);
	}

	@Override
	public void insertContractModel(Map<String, Object> param) {
		contractModelDao.insertContractModel(param);
	}

	@Override
	public void updateContractModel(Map<String, Object> param) {
		contractModelDao.updateContractModel(param);
	}

	@Override
	public void deleteContractModel(String id) {
		contractModelDao.deleteContractModel(id);
	}

	@Override
	public List<SystemInfo> getSystemInfoList(Map<String, Object> systemInfo) {
		return systemInfoDao.getSystemInfoList(systemInfo);
	}

	@Override
	public LoanParam getLoanParamById(Map<String, Object> param) {
		return paramsDao.getLoanParamById(param);
	}

}
