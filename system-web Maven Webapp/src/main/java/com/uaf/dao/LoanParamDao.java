package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.LoanCity;
import com.uaf.bean.LoanParam;

/**
 * 文件名：LoanParamDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface LoanParamDao {
	public List<LoanParam> getLoanParamPage(@Param("param") Map<String, Object> param);

	public Integer getLoanParamCount(@Param("param") Map<String, Object> param);

	public LoanParam getLoanParamById(Map<String, Object> param);
	
	public List<LoanParam> getLoanParamList(Map<String, Object> map);

	public void insertLoanParam(@Param("param") Map<String, Object> param);
	
	public void updateParam(@Param("param") Map<String, Object> param);

	public void deleteParam(@Param("id") String id);
}
