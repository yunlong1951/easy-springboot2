package com.example.boot.common.enums;

public enum OperateType {
	登录("登录"),
    新增("新增"),
    修改("修改"),
    删除("删除"),
    查询列表("查询列表"),
    审核("审核"),
    上下线("上下线"),
    启用禁用("启用禁用"),
    置顶权限("置顶权限"),
    其他("其他");

    private final String value;

    OperateType(String value) {
        this.value = value;
    }
    public static OperateType getType(String value) {
    	for (OperateType operateType : OperateType.values()) {
			if (operateType.value.equals("value")) {
				return operateType;
			}
		}
    	return null;
    }
    
    public static String getValue(OperateType operateType) {
    	return operateType.value;
    }
}
