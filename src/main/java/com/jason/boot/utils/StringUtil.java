package com.jason.boot.utils;

import java.util.UUID;

public class StringUtil {
	/**
	 * 生成uuid
	 * @return
	 */
	public static String createUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static boolean isBlank(Object obj){
		if(obj == null){
			return true;
		}else{
			if(obj instanceof String){
				return "".equals(((String) obj).trim());
			}
			if(obj instanceof java.util.List){
				return ((java.util.List) obj).size()==0;
			}
			return false;
		}
	}
}
