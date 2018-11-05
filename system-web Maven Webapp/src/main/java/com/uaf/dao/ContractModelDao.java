package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.ContractModel;

/**
 * 文件名：ContractModelDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface ContractModelDao {

	public List<ContractModel> getContractModelPage(@Param("param") Map<String, Object> param);

	public List<ContractModel> getContractModelList(@Param("param") Map<String, Object> param);

	public Integer getContractModelCount(@Param("param") Map<String, Object> param);

	public ContractModel getContractModelById(Map<String, Object> param);

	public void insertContractModel(@Param("param") Map<String, Object> param);

	public void updateContractModel(@Param("param") Map<String, Object> param);

	public void deleteContractModel(@Param("id") String id);
}
