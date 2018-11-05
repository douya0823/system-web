package me.gacl.test.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import web.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.util.BeanUtils;

/**
 * 文件名：AnnotationHandleServlet.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年6月8日上午11:15:51
 */
public class AnnotationHandleServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AnnotationHandleServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	private String pareRequestURL(HttpServletRequest request) {
		String path = request.getContextPath() + "/";// 项目名/MyProject
		String requestURL = request.getRequestURI();// 请求路径/MyProject/controllerName/methodName
		String midUrl = requestURL.replaceFirst(path, "");
		String lastUrl = midUrl.substring(0, midUrl.indexOf("."));
		return lastUrl;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将当前线程中HttpServletRequest对象存储到ThreadLocal中，以便在Controller类中使用
		WebContext.requestHodler.set(request);
		// 将当前线程中HttpServletResponse对象存储到ThreadLocal中，以便在Controller类中使用
		WebContext.responseHodler.set(response);
		// 解析url
		String lasturl = pareRequestURL(request);
		// 获取要使用的类
		Class<?> clazz = RequestMapingMap.getRequesetMap().get(lasturl);
		// 创建类的实例
		Object classInstance = BeanUtils.instanceClass(clazz);
		// 获取类中定义的方法
		Method[] methods = BeanUtils.findDeclaredMethods(clazz);
		Method method = null;
		for (Method m : methods) {// 循环方法，找匹配的方法进行执行
			if (m.isAnnotationPresent(RequestMapping.class)) {
				String anoPath = m.getAnnotation(RequestMapping.class).value();
				if (anoPath != null && !"".equals(anoPath.trim()) && lasturl.equals(anoPath.trim())) {
					// 找到要执行的目标方法
					method = m;
					break;
				}
			}
		}
		try {
			if (method != null) {
				// 执行目标方法处理用户请求
				Object retObject = method.invoke(classInstance);
				// 如果方法有返回值，那么就表示用户需要返回视图
				if (retObject != null) {
					View view = (View) retObject;
					if (view.getDispathAction().equals("forward")) {
						// 使用服务器端跳转方式
						request.getRequestDispatcher(view.getUrl()).forward(request, response);
					} else if (view.getDispathAction().equals("redirect")) {
						// 使用客户端跳转方式
						response.sendRedirect(request.getContextPath() + view.getUrl());
					} else {
						request.getRequestDispatcher(view.getUrl()).forward(request, response);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {

	}

}
