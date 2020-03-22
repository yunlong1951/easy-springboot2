package com.example.boot.common.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class JSONResult implements Serializable {
	
	private static JSONObject jsonProvider(int code, String msg, Object data) {
		JSONObject json = new JSONObject(3);
		json.put("code", code);
		json.put("msg", msg);
		json.put("data", data);
		return json;//JSON.toJSONString(json, SerializerFeature.WriteMapNullValue);
	}

	public static JSONObject callSuccess(Object obj) {
		return jsonProvider(1, "操作成功", obj);
	}

	public static JSONObject callSuccess() {
		return jsonProvider(1, "操作成功", null);
	}

	public static JSONObject callFail(Object obj) {
		return jsonProvider(0, "操作失败", obj);
	}

	public static JSONObject callSignFail(Object obj) {
		return jsonProvider(-1, "身份验证失败", obj);
	}

	public static JSONObject callLoginFail(Object obj) {
		return jsonProvider(-2, "登录异常", obj);
	}

	public static JSONObject callException(Object obj) {
		return jsonProvider(-3, "应用程序异常", obj);
	}

	public static JSONObject callInvalidParameter(String msg) {
		return jsonProvider(-4, msg, null);
	}
	public static JSONObject callInvalidParameter(String msg,Object object) {
		return jsonProvider(-4, msg, object);
	}

	public static JSONObject callInvalidRequest(String url) {
		return jsonProvider(-5, "非法请求",url);
	}

	public static JSONObject callNoData(Object obj) {
		return jsonProvider(-6, "暂无数据", null);
	}

	public static JSONObject callCustom(int code, String msg, Object obj) {
		return jsonProvider(code, msg, obj);
	}

	public static JSONObject callCustomMsg(String msg) {
		return jsonProvider(0, msg, null);
	}

	public static JSONObject callCustomData(Object data, Integer total) {
		return jsonProvider(0, "", data);
	}
}
