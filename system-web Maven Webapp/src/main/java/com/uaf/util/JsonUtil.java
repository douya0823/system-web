package com.uaf.util;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON工具类
 * @author sz05383
 *
 */
public class JsonUtil {

	/**
	 * 对象转换成json字符串 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		// disableHtmlEscaping:特殊字符不转义,统一日期格式
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj);
	}

	/**
	 * json字符串转成对象
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String str, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}

	/**
	 * json字符串转成对象 
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String str, Class<T> type) {
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}

}
