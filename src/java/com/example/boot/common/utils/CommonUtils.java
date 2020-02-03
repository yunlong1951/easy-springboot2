package com.example.boot.common.utils;

import java.util.UUID;

public class CommonUtils {
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
