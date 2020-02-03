package com.example.boot.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "path")
public class UploadPath {
	
	/**
	 * 静态资源转发路径
	 */
	private String staticAccessPath;
	/**
	 * 数据库存储路径
	 */
	private String staticPath;
	/**
	 * 文件真实存储路径
	 */
	private String uploadFolder;
	public String getStaticAccessPath() {
		return staticAccessPath;
	}
	public void setStaticAccessPath(String staticAccessPath) {
		this.staticAccessPath = staticAccessPath;
	}
	public String getStaticPath() {
		return staticPath;
	}
	public void setStaticPath(String staticPath) {
		this.staticPath = staticPath;
	}
	public String getUploadFolder() {
		return uploadFolder;
	}
	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}
	
}
