package com.example.boot.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class IpUtils {
	public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip) {
        String address = "";
        try {
            address = HttpUtils.sendPost(IP_URL, "ip=" + ip);
            if(address==""||address==null) {
            	return address;
            }
            System.out.println("address:"+address);
            JSONObject json = JSONObject.parseObject(address);
            System.out.println(json);
            JSONObject object = json.getObject("data", JSONObject.class);
            String region = object.getString("region");
            String city = object.getString("city");
            address = region + " " + city;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }
}
