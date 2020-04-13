package com.canton.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json的工具类。用于将对象转换成json格式的字符串。
 * 
 * @author Rosahen
 * @version 1.0 
 */
public class JsonUtil {
	
	private JsonUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 将对象转换成json字符串的方法。
	 * 
	 * @param object 某一个对象。
	 * @return 转换后的json格式字符串
	 * @throws JsonProcessingException
	 */
	public static String formatAsJson(Object object) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		try {
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
