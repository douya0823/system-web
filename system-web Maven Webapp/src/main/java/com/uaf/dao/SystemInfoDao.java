package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.LoanProduct;
import com.uaf.bean.SystemInfo;

/**
 * 文件名：SystemInfoDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface SystemInfoDao {
	public List<SystemInfo> getSystemInfoPage(@Param("systemInfo") Map<String, Object> systemInfo);

	public List<SystemInfo> getSystemInfoList(@Param("systemInfo") Map<String, Object> systemInfo);

	public Integer getSystemInfoCount(@Param("systemInfo") Map<String, Object> systemInfo);

	public SystemInfo getSystemInfoById(@Param("systemInfo") Map<String, Object> systemInfo);

	public void insertSystemInfo(@Param("systemInfo") SystemInfo systemInfo);

	public void updateSystemInfo(@Param("systemInfo") SystemInfo systemInfo);

	public void deleteSystemInfo(@Param("id") String id);
}
