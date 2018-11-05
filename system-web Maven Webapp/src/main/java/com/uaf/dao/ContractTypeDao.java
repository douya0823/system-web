package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.ContractType;
import com.uaf.bean.LoanProduct;

/**
 * 文件名：ContractTypeDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface ContractTypeDao {
	public List<ContractType> getContractTypePage(@Param("contractType") Map<String, Object> contractType);

	public Integer getContractTypeCount(@Param("contractType") Map<String, Object> contractType);

	public ContractType getContractTypeById(@Param("contractType") Map<String, Object> contractType);

	public void insertContractType(@Param("contractType") Map<String, Object> contractType);

	public List<ContractType> getContractTypeList(Map<String, Object> map);

	public void updateContractType(@Param("contractType") Map<String, Object> contractType);

	public void deleteContractType(@Param("id") String id);
}
