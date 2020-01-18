package com.example.boot.common.enums;

public enum OperateStatus {
	正常(0), 异常(1);

    
    private final int value;

    OperateStatus(int value) {
        this.value = value;
    }
}
