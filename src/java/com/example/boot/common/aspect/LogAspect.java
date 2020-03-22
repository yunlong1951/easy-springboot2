package com.example.boot.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.common.aspect.annotation.Log;
import com.example.boot.common.enums.LogType;
import com.example.boot.common.enums.OperateStatus;
import com.example.boot.model.log.OperateLog;
import com.example.boot.common.utils.IpUtils;
import com.example.boot.common.utils.ServletUtils;
import com.example.boot.service.log.OperateLogService;

@Aspect
@Component
@EnableAsync
public class LogAspect {
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	@Autowired
	private OperateLogService operateLogService;
	
	private OperateLog operateLog;

	@Pointcut("@annotation(com.example.boot.common.aspect.annotation.Log)")
	public void logPointCut() {
		operateLog = new OperateLog();
	}

	/**
	 * 前置通知
	 *
	 * @param joinPoint
	 */
	@AfterReturning(pointcut = "logPointCut()")
	public void doBefore(JoinPoint joinPoint) {
		handler(joinPoint, null);
	}

	/**
	 * 拦截异常操作
	 *
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(value = "logPointCut()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		handler(joinPoint, e);
	}
	
	
	
	protected void handler(final JoinPoint joinPoint, final Exception e) {
		try {
			Log controllerLog = getAnnotation(joinPoint);
			if (controllerLog == null) {
				return;
			}
			operateLog = new OperateLog();
			// 请求路径
			operateLog.setOperateUrl(ServletUtils.getRequest().getRequestURL().toString());
			operateLog.setOperateIp(IpUtils.getIp(ServletUtils.getRequest()));
			if (controllerLog.logType().equals(LogType.操作日志)) {
//				HttpSession session = ServletUtils.getRequest().getSession(); // 登录用户
				//TODO:处理有用户登录时记录操作id
			}

			if (e != null) {
				operateLog.setStatus(OperateStatus.异常);
				operateLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 500));
			}
			// 方法名
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			operateLog.setMethod(className + "." + methodName + "()");
			operateLog.setOperateTime(new Date());
			//
			getControllerDescription(controllerLog, operateLog);
			// 保存日志
//			operateLogService.save(operateLog);
			log.info("测试aop日志");
		} catch (Exception exp) {
			log.error("==前置通知异常==");
			log.error("异常信息:{}", exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	@AfterReturning(value = "logPointCut()",returning = "ret",argNames = "ret")
	public void logSuccess(Object ret) {
		
	}

	/**
	 * 注解中方法信息描述
	 *
	 * @param log
	 * @param operateLog
	 */
	private void getControllerDescription(Log log, OperateLog operateLog) {
		operateLog.setAction(log.action());
		operateLog.setTitle(log.title());
		operateLog.setLogType(log.logType());
		if (log.isSaveRequestData()) {
			setRequestValue(operateLog);
		}
	}

	/**
	 * 获取请求参数，放到log
	 *
	 * @param operaLog
	 */
	private void setRequestValue(OperateLog operaLog) {
		Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
		String params = JSONObject.toJSONString(map);
		operaLog.setOperateParam(params);
	}

	/**
	 * 是否存在注解存在就取
	 *
	 * @param joinPoint
	 * @return
	 */
	private Log getAnnotation(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if (method != null) {
			return method.getAnnotation(Log.class);
		}
		return null;
	}
}
