package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.ContractInfo;

/**
 * 文件名：ContractInfoDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface ContractInfoDao {

	public List<ContractInfo> getContractInfoPage(@Param("param") Map<String, Object> param);

	public Integer getContractInfoCount(@Param("param") Map<String, Object> param);

	public ContractInfo getContractInfoById(Map<String, Object> param);

	public void insertContractInfo(@Param("param") Map<String, Object> param);

	public void updateContractInfo(@Param("param") Map<String, Object> param);

	public void deleteContractInfo(@Param("id") String id);
	
	public List<ContractInfo> getContractInfoList(Map<String, Object> map);
}
