package web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * �ļ�����WebServlet.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��6��7������2:07:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebServlet {
	String value();
	String[] urlPatterns() default {""};
	String description() default "";
	String displayName() default "";
	String name() default "";
	WebInitParam[] initParams() default {};

}
