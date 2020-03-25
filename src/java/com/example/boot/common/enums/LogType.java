package com.example.boot.common.enums;

public enum LogType {
	 操作日志("操作日志"),访问日志("访问日志");
    private final String value;

    LogType(String value) {
        this.value = value;
    }
    
    public static LogType getType(String value) {
    	for (LogType logType : LogType.values()) {
			if (logType.value.equals(value) ) {
				return logType;
			}
		}
    	return null;
    }
    
    public static String getValue(LogType logType) {
		return logType.value;
	}
}
