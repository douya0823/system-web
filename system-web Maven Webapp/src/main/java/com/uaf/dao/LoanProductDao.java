package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.LoanParam;
import com.uaf.bean.LoanProduct;

/**
 * 文件名：LoanProductDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface LoanProductDao {
	public List<LoanProduct> getLoanProductPage(@Param("product") Map<String, Object> product);

	public Integer getLoanProductCount(@Param("product") Map<String, Object> product);

	public LoanProduct getLoanProductById(@Param("product") Map<String, Object> product);
	
	public List<LoanProduct> getProductList(Map<String, Object> map);

	public void insertLoanProduct(@Param("product") Map<String, Object> product);

	public void updateProduct(@Param("product") Map<String, Object> product);

	public void deleteProduct(@Param("id") String id);
}
