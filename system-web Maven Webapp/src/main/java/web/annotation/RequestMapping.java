package web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件名：RequestMapping.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年6月8日上午11:14:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequestMapping {
	public String value() default "";
}
