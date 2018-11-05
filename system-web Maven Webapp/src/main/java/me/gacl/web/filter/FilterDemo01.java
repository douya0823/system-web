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
 * ï¿½Ä¼ï¿½ï¿½ï¿½FilterDemo01.java
 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
 * ï¿½ï¿½ï¿½ß£ï¿½sz06025
 * ï¿½ï¿½ï¿½Ú£ï¿½2018ï¿½ï¿½5ï¿½ï¿½31ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½5:44:24
 */
public class FilterDemo01 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filterName = filterConfig.getFilterName();
		String name = filterConfig.getInitParameter("name");
		///·µ»Ø¹ýÂËÆ÷µÄËùÓÐ³õÊ¼»¯²ÎÊýµÄÃû×ÖµÄÃ¶¾Ù¼¯ºÏ¡£
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
