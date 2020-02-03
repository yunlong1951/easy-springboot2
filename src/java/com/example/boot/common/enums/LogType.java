package com.example.boot.common.enums;

public enum LogType {
	 操作日志(0),访问日志(1);
    private final int value;

    LogType(int value) {
        this.value = value;
    }
    
    public static LogType getType(int value) {
    	for (LogType logType : LogType.values()) {
			if (logType.value == value) {
				return logType;
			}
		}
    	return null;
    }
    
    public static Integer getValue(LogType logType) {
		return logType.value;
	}
}
