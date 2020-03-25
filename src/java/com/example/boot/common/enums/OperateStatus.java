package com.example.boot.common.enums;

public enum OperateStatus {
	正常("正常"), 异常("异常");

    
    private final String value;

    OperateStatus(String value) {
        this.value = value;
    }
    
    public static OperateStatus getType(String value) {
    	for (OperateStatus operateStatus : OperateStatus.values()) {
			if (operateStatus.value.equals(value)) {
				return operateStatus;
			}
		}
    	return null;
    }
    
    public static String getValue(OperateStatus operateStatus) {
    	return operateStatus.value;
    }
}
