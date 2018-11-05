package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.LoanCity;

/**
 * 文件名：LoanCityDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface LoanCityDao {
	public List<LoanCity> getLoanCityPage(@Param("loanCity") Map<String, Object> loanCity);

	public Integer getLoanCityCount(@Param("loanCity") Map<String, Object> loanCity);

	public LoanCity getLoanCityById(Map<String, Object> loanCity);

	public List<LoanCity> getLoanCityList(Map<String, Object> map);

	public void insertLoanCity(@Param("loanCity") Map<String, Object> loanCity);

	public void updateCity(@Param("loanCity") Map<String, Object> loanCity);

	public void deleteCity(@Param("id") String id);
}
