package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.ContractVersion;

/**
 * 文件名：ContractVersionDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface ContractVersionDao {

	public List<ContractVersion> getContractVersionPage(@Param("param") Map<String, Object> param);
	
	public List<ContractVersion> getContractVersionList(@Param("param") Map<String, Object> param);

	public Integer getContractVersionCount(@Param("param") Map<String, Object> param);

	public ContractVersion getContractVersionById(Map<String, Object> param);

	public void insertContractVersion(@Param("param") Map<String, Object> param);

	public void updateContractVersion(@Param("param") Map<String, Object> param);

	public void deleteContractVersion(@Param("id") String id);
}
