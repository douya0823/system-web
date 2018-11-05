package me.gacl.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * �ļ���FilterDemo01.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��5��31������5:44:24
 */
public class FilterDemo01 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filterName = filterConfig.getFilterName();
		String name = filterConfig.getInitParameter("name");
		///���ع����������г�ʼ�����������ֵ�ö�ټ��ϡ�
		Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String paramName = (String) initParameterNames.nextElement();
			//System.out.println(paramName);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("text/html;charset=UTF-8");
		//System.out.print("j");
		chain.doFilter(request, response);
		//System.out.print("/");

	}

}
