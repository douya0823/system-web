package me.gacl.test.servlet;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：RequestMapping.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年6月8日上午11:39:12
 */
public class RequestMapingMap {
	/**
	    * @Field: requesetMap
	    *          用于存储方法的访问路径
	    */
	private static Map<String, Class<?>> requesetMap = new HashMap<String, Class<?>>();

	public static Class<?> getClassName(String path) {
		return requesetMap.get(path);
	}

	public static void put(String path, Class<?> className) {
		requesetMap.put(path, className);
	}

	public static Map<String, Class<?>> getRequesetMap() {
		return requesetMap;
	}
}
