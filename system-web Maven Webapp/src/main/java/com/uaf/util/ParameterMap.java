package com.uaf.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件名：ParameterMap.java
 * 描述：
 * 作者：KJ00054
 * 日期：2018年8月6日上午11:07:00
 */
public class ParameterMap {

	public static Map<String,Object> getParameterMap(HttpServletRequest request) {

		Map<String,Object> parametersMap = new HashMap<String,Object>();
		Enumeration paramters = request.getParameterNames();
		while (paramters.hasMoreElements()) {
			String name = (String) paramters.nextElement();
			String[] values = request.getParameterValues(name);
			String value = "";
			if (values != null && values.length != 0) {
				for (int i = 0; i < values.length; i++) {
					value += values[i] + ',';
				}
				value = value.substring(0, value.length() - 1);
			}

			// 下面的判断是 如果参数值为空,就不存入parametersMap

			if (!"".equals(value.trim())) {
				parametersMap.put(name, value.trim());
			}

			// 这个是全部放入,没值的参数的value是"" 在此需要注意如果sql语句中是 isNotNull 和 isNotEmpty
			parametersMap.put(name, value.trim());
		}
		if(parametersMap.get("page")!=null&&parametersMap.get("rows")!=null){
			int page=Integer.parseInt(parametersMap.get("page").toString());
			int rows=Integer.parseInt(parametersMap.get("rows").toString());
			parametersMap.put("firstRow", (page-1)*rows);
			parametersMap.put("endRow", page*rows);
		}
		return parametersMap;
	}

}
