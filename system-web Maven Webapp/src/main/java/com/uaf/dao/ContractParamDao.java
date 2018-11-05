package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.ContractParam;

/**
 * 文件名：ContractParamDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface ContractParamDao {

	public List<ContractParam> getContractParamPage(@Param("param") Map<String, Object> param);

	public List<ContractParam> getContractParamList(@Param("param") Map<String, Object> param);

	public Integer getContractParamCount(@Param("param") Map<String, Object> param);

	public ContractParam getContractParamById(@Param("param") Map<String, Object> param);

	public void insertContractParam(@Param("param") Map<String, Object> param);

	public void updateContractParam(@Param("param") Map<String, Object> param);

	public void deleteContractParam(@Param("id") String id);
}
