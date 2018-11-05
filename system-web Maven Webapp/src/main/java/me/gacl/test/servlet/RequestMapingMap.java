package me.gacl.test.servlet;

import java.util.HashMap;
import java.util.Map;

/**
 * �ļ�����RequestMapping.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��6��8������11:39:12
 */
public class RequestMapingMap {
	/**
	    * @Field: requesetMap
	    *          ���ڴ洢�����ķ���·��
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
