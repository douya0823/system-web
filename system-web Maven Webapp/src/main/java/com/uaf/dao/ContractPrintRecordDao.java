package com.uaf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uaf.bean.ContractPrintRecord;

/**
 * 文件名：ContractPrintRecordDao.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年7月27日上午10:10:50
 */
public interface ContractPrintRecordDao {
	public List<ContractPrintRecord> getContractPrintRecord(@Param("record") Map<String, Object> record);

	public ContractPrintRecord getContractPrintRecordById(@Param("record") Map<String, Object> record);

	public void insertContractPrintRecord(@Param("record") ContractPrintRecord record);
}
