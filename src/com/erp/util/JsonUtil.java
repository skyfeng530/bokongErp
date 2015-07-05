package com.erp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	/**
	 * 把实体Bean、Map对象、数组、列表集合转换成Json串
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 *             String
	 */
	public static String getJsonStr(Object object) {

		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("data", object);
		
		return JSON.toJSONString(jsonMap);
	}

	public static void outJson(HttpServletResponse response, String jsonReuslt) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();

			writer.write(jsonReuslt);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}
}
