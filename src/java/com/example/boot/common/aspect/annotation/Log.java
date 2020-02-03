package com.example.boot.common.aspect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.boot.common.enums.LogType;
import com.example.boot.common.enums.OperateType;

/**
 * 
 * @author li132
 *
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 模块
	 * @return
	 */
	String title() default "";
	/**
	 * 功能
	 * @return
	 */
	OperateType action() default OperateType.其他;
	/**
	 * 是否保存请求参数
	 * @return
	 */
	boolean isSaveRequestData() default true;

	/**
	 * 日志类型
	 * @return
	 */
    LogType logType() default LogType.操作日志;
    
    String logInfo() default "";
}
