package com.uaf.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.LinkedCaseInsensitiveMap;

/**
 * 文件名：BeanToMapUtils.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月16日下午3:32:14
 */
public class BeanToMapUtils {
	/**  
	 * 将一个 Map 对象转化为一个 JavaBean  
	 * @param clazz 要转化的类型  
	 * @param map 包含属性值的 map  
	 * @return 转化出来的 JavaBean 对象  
	 * @throws IntrospectionException 如果分析类属性失败  
	 * @throws IllegalAccessException 如果实例化 JavaBean 失败  
	 * @throws InstantiationException 如果实例化 JavaBean 失败  
	 * @throws InvocationTargetException 如果调用属性的 setter 方法失败  
	 */
	public static <T> T toBean(Class<T> clazz, Map<String, Object> map) {
		T obj = null;
		try {
			if (map != null && map.size() > 0) {
				Map<String, Object> result = new LinkedCaseInsensitiveMap();
				result.putAll(map);
				BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
				obj = clazz.newInstance(); // 创建 JavaBean 对象

				// 给 JavaBean 对象的属性赋值
				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
				for (int i = 0; i < propertyDescriptors.length; i++) {
					PropertyDescriptor descriptor = propertyDescriptors[i];
					String propertyName = descriptor.getName();
					Class<?> propertyType = descriptor.getPropertyType();
					if (result.get(propertyName) != null) {
						// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
						Object value = result.get(propertyName);
						Object newValue = null;
						if (propertyType.getName() == "java.lang.Integer") {
							String val=String.valueOf(value);
							if(val.indexOf(".")>-1){
								val=val.substring(0,val.indexOf("."));
							}
							newValue = Integer.valueOf(val + "");
						} else if (propertyType.getName() == "java.util.Date") {
							SimpleDateFormat sf1 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
							try {
								Date date = sf1.parse(value.toString());
								newValue = date;
							} catch (ParseException e) {
								System.out.print("时间转换错误");
								e.printStackTrace();
							}
						} else {

							newValue = value + "";
						}

						if ("".equals(newValue)) {
							newValue = null;
						}
						Object[] args = new Object[1];
						args[0] = newValue;
						try {
							descriptor.getWriteMethod().invoke(obj, args);
						} catch (InvocationTargetException e) {
							System.out.println("字段映射失败");
						}
					}
				}
			}
		} catch (IllegalAccessException e) {
			System.out.println("实例化 JavaBean 失败");
		} catch (IntrospectionException e) {
			System.out.println("分析类属性失败");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("映射错误");
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.println("实例化 JavaBean 失败");
		}
		return (T) obj;
	}

	/**  
	 * 将一个 JavaBean 对象转化为一个 Map  
	 * @param bean 要转化的JavaBean 对象  
	 * @return 转化出来的 Map 对象  
	 * @throws IntrospectionException 如果分析类属性失败  
	 * @throws IllegalAccessException 如果实例化 JavaBean 失败  
	 * @throws InvocationTargetException 如果调用属性的 setter 方法失败  
	 */
	@SuppressWarnings("rawtypes")
	public static Map toMap(Object bean) {
		Class<? extends Object> clazz = bean.getClass();
		Map<Object, Object> returnMap = new HashMap<Object, Object>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = null;
					result = readMethod.invoke(bean, new Object[0]);
					if (null != propertyName) {
						propertyName = propertyName.toString();
					}
					if (null != result) {
						result = result.toString();
					}
					returnMap.put(propertyName, result);
				}
			}
		} catch (IntrospectionException e) {
			System.out.println("分析类属性失败");
		} catch (IllegalAccessException e) {
			System.out.println("实例化 JavaBean 失败");
		} catch (IllegalArgumentException e) {
			System.out.println("映射错误");
		} catch (InvocationTargetException e) {
			System.out.println("调用属性的 setter 方法失败");
		}
		return returnMap;
	}

	public static Map<String, Object> toLowerCase(Map<String, Object> map) {
		HashMap<String, Object> newMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (!key.equals(key.toLowerCase())) {
				String newKey = key.toLowerCase();
				newMap.put(newKey, value);
			} else {
				newMap.put(key, value);
			}
		}
		return newMap;
	}
}