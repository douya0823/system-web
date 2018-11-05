package me.gacl.test.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 文件名：WebContext.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年6月8日上午11:25:47
 */
public class WebContext {
	public static ThreadLocal<HttpServletRequest> requestHodler = new ThreadLocal<HttpServletRequest>();
	public static ThreadLocal<HttpServletResponse> responseHodler = new ThreadLocal<HttpServletResponse>();

	public HttpServletRequest getRequest() {
		return requestHodler.get();
	}

	public HttpSession getSession() {
		return requestHodler.get().getSession();
	}

	public ServletContext getServletContext() {
		return requestHodler.get().getSession().getServletContext();
	}

	public HttpServletResponse getResponse() {
		return responseHodler.get();
	}
}
