package com.example.boot.common.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class JSONResult implements Serializable {
	
	private static JSONObject jsonProvider(int code, String msg, Object data, Integer total) {
		JSONObject json = new JSONObject(4);
		json.put("code", code);
		json.put("msg", msg);
		json.put("data", data);
		json.put("total", total);
		return json;//JSON.toJSONString(json, SerializerFeature.WriteMapNullValue);
	}

	public static JSONObject callSuccess(Object obj, Integer total) {
		return jsonProvider(1, "操作成功", obj, total);
	}

	public static JSONObject callSuccess(Object obj) {
		return jsonProvider(1, "操作成功", obj, 1);
	}

	public static JSONObject callSuccess() {
		return jsonProvider(1, "操作成功", null, 1);
	}

	public static JSONObject callSuccess(Object obj, String msg) {
		return jsonProvider(1, msg, obj, 1);
	}

	public static JSONObject callFail(Object obj) {
		return jsonProvider(0, "操作失败", obj, 0);
	}

	public static JSONObject callFail(Object obj, String msg) {
		return jsonProvider(0, msg, obj, 0);
	}

	public static JSONObject callSignFail(Object obj) {
		return jsonProvider(-1, "身份验证失败", obj, 0);
	}

	public static JSONObject callException(Object obj) {
		return jsonProvider(-2, "应用程序异常", obj, 0);
	}

	public static JSONObject callInvalidParameter(Object obj) {
		return jsonProvider(-3, "非法参数", obj, 0);
	}

	public static JSONObject callInvalidParameter(String msg) {
		return jsonProvider(-3, msg, null, 0);
	}

	public static JSONObject callNoData(Object obj) {
		return jsonProvider(-4, "暂无数据", obj, 0);
	}

	public static JSONObject callAlreadyExisted(String msg) {
		return jsonProvider(-5, msg, null, 0);
	}

	public static JSONObject callCustom(int code, String msg, Object obj, Integer total) {
		return jsonProvider(code, msg, obj, total);
	}

	public static JSONObject callCustomMsg(String msg) {
		return jsonProvider(0, msg, null, 0);
	}

	public static JSONObject callCustomData(Object data, Integer total) {
		return jsonProvider(0, "", data, total);
	}
}
