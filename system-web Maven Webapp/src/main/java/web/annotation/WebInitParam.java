package web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �ļ�����WebInitParam.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��6��7������2:12:05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebInitParam {
	String paramName() default "";
	String paramValue() default "";
}
