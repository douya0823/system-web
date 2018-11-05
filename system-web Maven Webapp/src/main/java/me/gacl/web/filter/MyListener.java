package me.gacl.web.filter;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * �ļ���MyLinstenner.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��6��6������2:19:15
 */
public class MyListener implements ServletContextAttributeListener{
	
	@Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中添加了属性:{0}，属性值是:{1}"
                ,scab.getName()
                ,scab.getValue());
        //System.out.println(str);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中删除属性:{0}，属性值是:{1}"
                ,scab.getName()
                ,scab.getValue());
        //System.out.println(str);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中替换了属性:{0}的值"
                ,scab.getName());
        //System.out.println(str);
    }

}
