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
 * �ļ�����AnnotationHandleServlet.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��6��8������11:15:51
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
		String path = request.getContextPath() + "/";// ��Ŀ��/MyProject
		String requestURL = request.getRequestURI();// ����·��/MyProject/controllerName/methodName
		String midUrl = requestURL.replaceFirst(path, "");
		String lastUrl = midUrl.substring(0, midUrl.indexOf("."));
		return lastUrl;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����ǰ�߳���HttpServletRequest����洢��ThreadLocal�У��Ա���Controller����ʹ��
		WebContext.requestHodler.set(request);
		// ����ǰ�߳���HttpServletResponse����洢��ThreadLocal�У��Ա���Controller����ʹ��
		WebContext.responseHodler.set(response);
		// ����url
		String lasturl = pareRequestURL(request);
		// ��ȡҪʹ�õ���
		Class<?> clazz = RequestMapingMap.getRequesetMap().get(lasturl);
		// �������ʵ��
		Object classInstance = BeanUtils.instanceClass(clazz);
		// ��ȡ���ж���ķ���
		Method[] methods = BeanUtils.findDeclaredMethods(clazz);
		Method method = null;
		for (Method m : methods) {// ѭ����������ƥ��ķ�������ִ��
			if (m.isAnnotationPresent(RequestMapping.class)) {
				String anoPath = m.getAnnotation(RequestMapping.class).value();
				if (anoPath != null && !"".equals(anoPath.trim()) && lasturl.equals(anoPath.trim())) {
					// �ҵ�Ҫִ�е�Ŀ�귽��
					method = m;
					break;
				}
			}
		}
		try {
			if (method != null) {
				// ִ��Ŀ�귽�������û�����
				Object retObject = method.invoke(classInstance);
				// ��������з���ֵ����ô�ͱ�ʾ�û���Ҫ������ͼ
				if (retObject != null) {
					View view = (View) retObject;
					if (view.getDispathAction().equals("forward")) {
						// ʹ�÷���������ת��ʽ
						request.getRequestDispatcher(view.getUrl()).forward(request, response);
					} else if (view.getDispathAction().equals("redirect")) {
						// ʹ�ÿͻ�����ת��ʽ
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
