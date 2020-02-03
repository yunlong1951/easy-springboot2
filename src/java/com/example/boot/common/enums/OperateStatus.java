package com.example.boot.common.enums;

public enum OperateStatus {
	正常(0), 异常(1);

    
    private final int value;

    OperateStatus(int value) {
        this.value = value;
    }
    
    public static OperateStatus getType(int value) {
    	for (OperateStatus operateStatus : OperateStatus.values()) {
			if (operateStatus.value == value) {
				return operateStatus;
			}
		}
    	return null;
    }
    
    public static Integer getValue(OperateStatus operateStatus) {
    	return operateStatus.value;
    }
}
