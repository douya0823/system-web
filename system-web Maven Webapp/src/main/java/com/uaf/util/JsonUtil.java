package com.uaf.util;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON������
 * @author sz05383
 *
 */
public class JsonUtil {

	/**
	 * ����ת����json�ַ��� 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		// disableHtmlEscaping:�����ַ���ת��,ͳһ���ڸ�ʽ
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj);
	}

	/**
	 * json�ַ���ת�ɶ���
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String str, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}

	/**
	 * json�ַ���ת�ɶ��� 
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String str, Class<T> type) {
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}

}
