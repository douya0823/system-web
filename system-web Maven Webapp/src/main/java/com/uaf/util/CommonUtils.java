package com.uaf.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**   
 * @ClassName: CommonUtils  
 * @Description: 常用工具类  
 * @author: marx.liao
 * @date 2016-9-13 上午10:19:51  
 *     
 */
public class CommonUtils {

	/**
	 * 字符串是否为空
	 * @param cs
	 * @return
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串是否为不为空
	 * @param cs
	 * @return
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	/**
	 * 指定字符是否为空
	 * 		特殊处理(int)c=160的情况
	 * @param c
	 * @return
	 */
	private static boolean isWhitespace(char c) {
		return Character.isWhitespace(c) || (int) c == 160;
	}

	/**
	 * 时间字段的处理
	 * @param str
	 * @return 空返回true
	 */
	public static boolean isNull(String str) {
		if (CommonUtils.isBlank(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 时间字段的处理
	 * @param str
	 * @return 空返回false
	 */
	public static boolean notNull(String str) {
		return !isNull(str);
	}

	/**
	 * 
	 * @Method: tojson    
	 * @Description: 对象转换成json字符串 
	 * @author: marx.liao
	 * @date 2016-9-13 上午10:46:52
	 * @param obj
	 * @return       
	 * @throws
	 */
	// public static String tojson(Object obj){
	// Gson gson = new
	// GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	// return gson.toJson(obj);
	// }

	/**
	 * 空字节转换为null
	 * @param str
	 * @return
	 * 作者：marx.liao
	 * 日期：2016-9-13 上午11:40:32
	 */
	public static String blankToNUll(String str) {
		if ("".equals(str)) {
			return null;
		}
		return str;
	}

	/**
	 * 封装返回数据
	 * @param o
	 * @return
	 */
	public static Map<String, Object> putBackMessage(Object o) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (o == null) {
			o = new Object();
		}
		map.put(Constant.RESULT_CODE, Constant.RESULT_SUCCESS);
		map.put(Constant.DATA, o);
		return map;
	}

	/**
	 * 封装异常返回数据
	 * @param o
	 * @return
	 */
	public static Map<String, Object> putBackError() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.RESULT_CODE, Constant.RESULT_ERROR);
		map.put(Constant.DATA, Constant.RESULT_EXCEPTION);
		return map;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> putReceiveMessage(String info) {
		JSONObject reObject2 = JSONObject.parseObject(info);
		return (Map<String, Object>) reObject2;
	}

	/**
	 * 生成流程编号(19位),8位日期+4位分行号+2位进件类型(00 扫描关键录入 | 01 客服预约)+5位流水号
	 * @return
	 */
	public static synchronized String getUAFNbr() {
		java.util.Date oToday;
		SimpleDateFormat oFormat;
		oToday = new Date();
		oFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String sDate = oFormat.format(oToday);
		return sDate;
	}

	public static String clearNull(String paramString) {
		if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.trim().equals("null"))) {
			return "";
		}
		return paramString.trim();
	}

	/**
	 * 计算执行时间
	 * @param start
	 * @return 时间
	 */
	public static String calculation(long start) {
		String res = "";
		long time = System.currentTimeMillis() - start;
		if (time == 0)
			return "少于 1 毫秒";
		int d = (int) (time / (24 * 3600 * 1000));
		int h = (int) ((time / 3600000) % 24);
		int m = (int) ((time / 60000) % 60);
		int s = (int) ((time / 1000) % 60);
		int ms = (int) (time % 1000);

		res = (d > 0 ? d + " 天 " : "") + (h > 0 ? h + " 小时 " : "") + (m > 0 ? m + " 分 " : "")
				+ (s > 0 ? s + " 秒 " : "") + (ms > 0 ? ms + " 毫秒" : "");
		return res;
	}

	public static String addHGtoAcctNo(String acctNo) {
		if (acctNo == null || acctNo.length() != 15) {
			return null;
		} else {
			StringBuilder sb = new StringBuilder(acctNo);
			return sb.insert(13, '-').toString();
		}
	}

	public static String cutHGtoAcctNo(String acctNo) {
		if (acctNo == null || acctNo.length() != 16) {
			return null;
		} else {
			return acctNo.replace("-", "");
		}
	}

	/**
	* 通过,号分割数据
	* @param adress
	* @return
	* 作者：anthony
	* 日期：2017年9月25日下午4:50:39
	*/
	public static String[] splitCharacters(String adress) {
		return StringUtils.split(adress, ',');
	}

	public static void main(String[] agrs) {
		System.out.println(addHGtoAcctNo("020101100273501"));
		System.out.println(cutHGtoAcctNo("0201011002735-01"));
	}

	public static String valueOf(Object b) {
		return b == null ? null : b.toString();

	}

	public static Integer valueOfInteger(Object b) {
		String temp = valueOf(b);
		if (temp != null) {
			return Integer.valueOf(temp);
		} else {
			return null;
		}
	}
	public static Double valueOfDouble(Object b) {
		String temp = valueOf(b);
		if (temp != null) {
			return Double.parseDouble(temp);
		} else {
			return null;
		}
	}

	public static Integer doubleToInteger(Object b){
		if(b!=null){
			Double temp=valueOfDouble(b);
			if(temp.intValue()==0){
				return temp.intValue();
			}
			return temp.intValue();
		}else{
			return null;
		}
	}
/**
 * 判断map value是否为空
 */
	public static boolean mapValueIsNull(Map<String, Object> map,String key){
		if(map==null||map.size()==0){
			return true;
		}else if(map.get(key)==null){
			return true;
		}else{
			return false;
		}
	}
	public static boolean checkDouble(String mes) {
		boolean bCheckResult=true;
		try{   
		    Double dCheckValue = Double.parseDouble(mes);  
		        if (dCheckValue instanceof Double == false){  
		            bCheckResult = false;  
		        }  
		}catch(Exception e)  {    
		        return false;
		}  
        return bCheckResult;
	}
}
