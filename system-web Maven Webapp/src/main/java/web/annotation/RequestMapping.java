package web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �ļ�����RequestMapping.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��6��8������11:14:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequestMapping {
	public String value() default "";
}
