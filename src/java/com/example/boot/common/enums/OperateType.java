package com.example.boot.common.enums;

public enum OperateType {
	登录(0), 新增(1), 修改(2), 删除(3), 查询列表(4),审核(5),上下线(6),启用禁用(7),置顶权限(8),其他(8);

    private final int value;

    OperateType(int value) {
        this.value = value;
    }
}
