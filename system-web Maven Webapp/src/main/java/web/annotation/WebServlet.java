package web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 文件名：WebServlet.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年6月7日下午2:07:15
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
