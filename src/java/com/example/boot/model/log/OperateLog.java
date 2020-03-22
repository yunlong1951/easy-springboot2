package com.example.boot.model.log;

import java.util.Date;

import com.example.boot.common.base.BaseModel;
import com.example.boot.common.enums.LogType;
import com.example.boot.common.enums.OperateStatus;
import com.example.boot.common.enums.OperateType;

public class OperateLog extends BaseModel {
	private Long id;

	/**
	 * 模块标题
	 */
	private String title;

	/**
	 * 功能请求
	 */
	private OperateType action;

	/**
	 * 方法名称
	 */
	private String method;

	/**
	 * 操作人员
	 */
	private String operateUser;

	/**
	 * 请求URL
	 */
	private String operateUrl;

	/**
	 * 主机地址
	 */
	private String operateIp;

	/**
	 * 操作地点
	 */
	private String operateLocation;

	/**
	 * 请求参数
	 */
	private String operateParam;

	/**
	 * 操作状态（0正常 1异常）
	 */
	private OperateStatus status;

	/**
	 * 错误消息
	 */
	private String errorMsg;

	/**
	 * 操作时间
	 */
	private Date operateTime;

	private LogType logType; // 日志类型

	private String logInfo;

	private static final long serialVersionUID = 1L;

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	@Override
	public String toString() {
		return "OperateLog [id=" + id + ", title=" + title + ", action=" + action + ", method=" + method
				+ ", operateUser=" + operateUser + ", operateUrl=" + operateUrl + ", operateIp=" + operateIp
				+ ", operateLocation=" + operateLocation + ", operateParam=" + operateParam + ", status=" + status
				+ ", errorMsg=" + errorMsg + ", operateTime=" + operateTime + ", logType=" + logType + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAction() {
		return OperateType.getValue(action);
	}

	public OperateType getActionType() {
		return this.action;
	}

	public void setAction(OperateType action) {
		this.action = action;
	}

	public void setAction(Integer action) {
		this.action = OperateType.getType(action);
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	public String getOperateUrl() {
		return operateUrl;
	}

	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}

	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public String getOperateLocation() {
		return operateLocation;
	}

	public void setOperateLocation(String operateLocation) {
		this.operateLocation = operateLocation;
	}

	public String getOperateParam() {
		return operateParam;
	}

	public void setOperateParam(String operateParam) {
		this.operateParam = operateParam;
	}

	public Integer getStatus() {
		return OperateStatus.getValue(status);
	}

	public OperateStatus getStatusType() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = OperateStatus.getType(status);
	}

	public void setStatus(OperateStatus status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public LogType getLogType() {
		return logType;
	}

	public LogType getLogTypeType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public void setLogType(Integer logType) {
		this.logType = LogType.getType(logType);
	}

}
